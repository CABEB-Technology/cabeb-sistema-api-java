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
public class Usuario extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

    private String usuario;
    private String senha;
}
