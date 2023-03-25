package br.com.cabeb.api.entity;

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
    private String telefone;

    private String cep;
    private String numero;
    private String endereco;

    private LocalDate dataNascimento;

    private LocalDateTime criado;
    private LocalDateTime modificado;
}
