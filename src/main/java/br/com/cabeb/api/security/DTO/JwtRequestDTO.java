package br.com.cabeb.api.security.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestDTO {

    private String email;
    private String senha;
}