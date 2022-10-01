package br.com.cabeb.api.java.security.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String email;
    private String senha;
}