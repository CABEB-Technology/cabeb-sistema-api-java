package br.com.cabeb.api.java.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String email;
    private String usuario;
    private String senha;
    private String cpf;

    private LocalDateTime criado;
    private LocalDateTime modificado;
}
