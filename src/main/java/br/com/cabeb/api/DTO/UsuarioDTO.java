package br.com.cabeb.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends AbstractDTO {

    private String usuario;
    private String senha;
}
