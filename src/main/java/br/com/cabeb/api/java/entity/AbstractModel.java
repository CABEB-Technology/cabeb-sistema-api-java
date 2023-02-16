package br.com.cabeb.api.java.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
public abstract class AbstractModel {

    private String nome;
    private String cpf;
    private String email;
    private String matricula;
    private String endereco;
    private String Telefone;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    private LocalDateTime criado;
    private LocalDateTime modificado;
}
