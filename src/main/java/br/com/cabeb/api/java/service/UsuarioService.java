package br.com.cabeb.api.java.service;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.exception.BadRequestException;
import br.com.cabeb.api.java.lib.CpfValidate;
import br.com.cabeb.api.java.lib.EmailValidate;
import br.com.cabeb.api.java.repository.UsuarioRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    public Usuario criarUsuario(Usuario usuario) {

        if (!CpfValidate.isCPF(usuario.getCpf())) throw new BadRequestException("Cpf inválido");
        if (!EmailValidate.isEmail(usuario.getEmail())) throw new BadRequestException("E-mail inválido");

        if (repository.findByEmail(usuario.getEmail()) != null) throw new BadRequestException("E-mail já cadastrado");
        if (repository.findByUsuario(usuario.getUsuario()) != null) throw new BadRequestException("Usuário já cadastrado");

        if (usuario.getSenha().length() < 8) throw new BadRequestException("Senha deve conter mais de 8 caracteres");

        String senhaHash = this.passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senhaHash);

        usuario.setCpf(CpfValidate.formatarCPF(usuario.getCpf()));
        usuario.setCriado(LocalDateTime.now());
        usuario.setModificado(LocalDateTime.now());

        return this.repository.save(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        return this.repository.findByEmail(email);
    }

    public Usuario obterUsuarioPorId(Long id) {
        Optional<Usuario> usuario = this.repository.findById(id);

        return usuario.orElseThrow(() -> new BadRequestException("Usuário não encontrado"));
    }

    public List<Usuario> obterTodosUsuarios() {
        return this.repository.findAll();
    }

    public void deletarUsuario(Long id) {
        boolean exists = this.repository.existsById(id);
        if(exists) this.repository.deleteById(id);
    }
}
