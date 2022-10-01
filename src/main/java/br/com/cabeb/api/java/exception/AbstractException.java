package br.com.cabeb.api.java.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractException extends RuntimeException {

    private String erro;
    private String descricao;

    public AbstractException(String erro, String descricao) {
        this.erro = erro;
        this.descricao = descricao;
    }
}