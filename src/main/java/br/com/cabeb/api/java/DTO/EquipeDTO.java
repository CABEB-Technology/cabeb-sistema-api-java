package br.com.cabeb.api.java.DTO;

import br.com.cabeb.api.java.entity.PerfilEquipe;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipeDTO extends AbstractDTO {

    private Integer cargaHoraria;
    private PerfilEquipe perfilEquipe;
}
