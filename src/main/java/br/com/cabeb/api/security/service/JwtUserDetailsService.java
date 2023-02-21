package br.com.cabeb.api.security.service;

import br.com.cabeb.api.entity.Usuario;
import br.com.cabeb.api.exception.NotFoundException;
import br.com.cabeb.api.service.impl.UsuarioServiceImpl;
import br.com.cabeb.api.service.UsuarioService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioService service;

    public JwtUserDetailsService(UsuarioServiceImpl service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws NotFoundException {
        Usuario usuario = this.service.obterUsuarioPorEmail(email);

        return new User(email, usuario.getSenha(), new ArrayList<>());
    }
}
