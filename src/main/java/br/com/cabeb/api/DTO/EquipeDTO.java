package br.com.cabeb.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipeDTO extends AbstractDTO {

    private Integer cargaHoraria;
    private PerfilEquipeDTO perfilEquipe;
}
