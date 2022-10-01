package br.com.cabeb.api.java.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime criado;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime modificado;
}
