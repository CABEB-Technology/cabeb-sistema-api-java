package br.com.cabeb.api.java.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public abstract class AbstractDTO {
    private Long id;

    private String cpf;
    private String email;
    private String matricula;
    private String endereco;
    private String Telefone;

    private LocalDateTime dataNascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime criado;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime modificado;
}
