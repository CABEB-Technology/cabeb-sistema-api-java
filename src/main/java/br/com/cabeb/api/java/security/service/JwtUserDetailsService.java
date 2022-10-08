package br.com.cabeb.api.java.security.service;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.exception.NotFoundException;
import br.com.cabeb.api.java.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws NotFoundException {
        Usuario usuario = this.service.buscarUsuarioPorEmail(email);

        return new User(email, usuario.getSenha(), new ArrayList<>());
    }
}
