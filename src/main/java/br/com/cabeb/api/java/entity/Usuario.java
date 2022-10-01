package br.com.cabeb.api.java.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Audited
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
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
