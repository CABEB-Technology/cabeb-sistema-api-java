package br.com.cabeb.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Getter @Setter
@NoArgsConstructor
@AuditOverride(forClass = AbstractModel.class)
public class Equipe extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipe_seq")
    @SequenceGenerator(name = "equipe_seq", allocationSize = 1)
    private Long id;

    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "perfil_equipe_id")
    private PerfilEquipe perfilEquipe;
}
 