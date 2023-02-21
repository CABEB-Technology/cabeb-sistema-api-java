package br.com.cabeb.api.service.impl;

import br.com.cabeb.api.entity.Usuario;
import br.com.cabeb.api.exception.BadRequestException;
import br.com.cabeb.api.exception.NotFoundException;
import br.com.cabeb.api.lib.CpfValidate;
import br.com.cabeb.api.lib.Validar;
import br.com.cabeb.api.repository.UsuarioRepository;
import br.com.cabeb.api.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(PasswordEncoder passwordEncoder, UsuarioRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public String encryptarSenha(String senha) {
        return this.passwordEncoder.encode(senha);
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {

        Validar.validarObjeto(usuario);

        if (repository.findByEmail(usuario.getEmail()) != null) throw new BadRequestException("E-mail já cadastrado");
        if (repository.findByUsuario(usuario.getUsuario()) != null) throw new BadRequestException("Usuário já cadastrado");

        if (usuario.getSenha().length() < 8) throw new BadRequestException("Senha deve conter mais de 8 caracteres");

        usuario.setSenha(this.encryptarSenha(usuario.getSenha()));

        usuario.setCpf(CpfValidate.formatarCPF(usuario.getCpf()));
        usuario.setCriado(LocalDateTime.now());
        usuario.setModificado(LocalDateTime.now());

        return this.repository.save(usuario);
    }

    @Override
    public Usuario obterUsuarioPorEmail(String email) {

        return this.repository.findByEmail(email);
    }

    @Override
    public Usuario obterUsuarioPorId(Long id) {
        Optional<Usuario> usuario = this.repository.findById(id);
        return usuario.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public List<Usuario> obterTodosUsuarios() {
        return this.repository.findAll();
    }

    public void deletarUsuario(Long id) {
        boolean exists = this.repository.existsById(id);
        if(exists) this.repository.deleteById(id);
    }
}
