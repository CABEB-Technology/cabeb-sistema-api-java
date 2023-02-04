package br.com.cabeb.api.java.security.service;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.exception.NotFoundException;
import br.com.cabeb.api.java.service.UsuarioService;
import br.com.cabeb.api.java.service.impl.IUsuarioService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final IUsuarioService service;

    public JwtUserDetailsService(UsuarioService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws NotFoundException {
        Usuario usuario = this.service.obterUsuarioPorEmail(email);

        return new User(email, usuario.getSenha(), new ArrayList<>());
    }
}
