package br.com.cabeb.api.java.exception.message;

import lombok.Getter;

@Getter
public class ErrorMessage {

    private int status;
    private String erro;
    private String descricao;

    public ErrorMessage(int status, String erro, String descricao) {
        this.status = status;
        this.erro = erro;
        this.descricao = descricao;
    }
}