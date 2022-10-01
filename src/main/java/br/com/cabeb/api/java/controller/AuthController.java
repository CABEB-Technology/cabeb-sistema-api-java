package br.com.cabeb.api.java.controller;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.exception.BadRequestException;
import br.com.cabeb.api.java.security.DTO.JwtRequest;
import br.com.cabeb.api.java.security.DTO.JwtResponse;
import br.com.cabeb.api.java.security.lib.JwtTokenUtil;
import br.com.cabeb.api.java.security.service.JwtUserDetailsService;
import br.com.cabeb.api.java.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    private void autenticacao(String email, String senha) throws BadRequestException {
        Usuario usuario = this.usuarioService.buscarUsuarioPorEmail(email);

        if (usuario == null) throw new BadRequestException("E-mail inválido");
        if (!passwordEncoder.matches(senha, usuario.getSenha())) throw new BadRequestException("Senha inválida");
    }

    @PostMapping
    public ResponseEntity<JwtResponse> criarAutenticacaoToken(@RequestBody JwtRequest response) {
        this.autenticacao(response.getEmail(), response.getSenha());

        Usuario usuario = this.usuarioService.buscarUsuarioPorEmail(response.getEmail());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(response.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        JwtResponse jwtResponse = new JwtResponse(token, usuario.getId(), usuario.getUsuario());

        return new ResponseEntity<>(jwtResponse, HttpStatus.CREATED);
    }
}
