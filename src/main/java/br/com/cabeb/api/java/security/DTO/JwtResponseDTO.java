package br.com.cabeb.api.java.security.DTO;

import lombok.Getter;

@Getter
public class JwtResponseDTO {

    private final Long id;
    private final String token;
    private final String usuario;


    public JwtResponseDTO(String jwttoken, Long id, String usuario) {
        this.id = id;
        this.token = jwttoken;
        this.usuario = usuario;
    }
}