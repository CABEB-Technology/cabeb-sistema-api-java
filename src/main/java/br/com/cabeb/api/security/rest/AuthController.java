package br.com.cabeb.api.security.rest;

import br.com.cabeb.api.entity.Usuario;
import br.com.cabeb.api.exception.BadRequestException;
import br.com.cabeb.api.security.DTO.JwtRequestDTO;
import br.com.cabeb.api.security.DTO.JwtResponseDTO;
import br.com.cabeb.api.security.lib.JwtTokenUtil;
import br.com.cabeb.api.security.service.JwtUserDetailsService;
import br.com.cabeb.api.service.impl.UsuarioServiceImpl;
import br.com.cabeb.api.service.UsuarioService;
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

    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;

    public AuthController(JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, UsuarioServiceImpl usuarioService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.usuarioService = usuarioService;
    }

    private void autenticacao(String email, String senha) throws BadRequestException {
        Usuario usuario = this.usuarioService.obterUsuarioPorEmail(email);

        if (usuario == null) throw new BadRequestException("E-mail ou Senha inválidos");
        if (!passwordEncoder.matches(senha, usuario.getSenha())) throw new BadRequestException("E-mail ou Senha inválidos");
    }

    @PostMapping
    public ResponseEntity<JwtResponseDTO> criarAutenticacaoToken(@RequestBody JwtRequestDTO response) {
        this.autenticacao(response.getEmail(), response.getSenha());

        Usuario usuario = this.usuarioService.obterUsuarioPorEmail(response.getEmail());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(response.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        JwtResponseDTO jwtResponse = new JwtResponseDTO(token, usuario.getId(), usuario.getUsuario());

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
}
