package br.com.cabeb.api.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public abstract class AbstractDTO {
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String matricula;
    private String telefone;

    private String cep;
    private String endereco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private LocalDateTime modificado;
}
