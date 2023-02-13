package br.com.cabeb.api.java.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipeDTO extends AbstractDTO {

    private Integer cargaHoraria;
    private String equipe;
}
