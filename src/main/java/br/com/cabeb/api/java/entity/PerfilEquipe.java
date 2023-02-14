package br.com.cabeb.api.java.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Getter @Setter
public class PerfilEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_equipe_seq")
    @SequenceGenerator(name = "perfil_equipe_seq", allocationSize = 1)
    private Long id;

    private String perfil;
}
