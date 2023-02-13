package br.com.cabeb.api.java.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
public class AbstractModel {

    private String cpf;
    private String email;
    private String matricula;
    private String endereco;
    private String Telefone;

    private LocalDateTime dataNascimento;
    private LocalDateTime criado;
    private LocalDateTime modificado;
}
