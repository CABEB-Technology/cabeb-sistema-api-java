package br.com.cabeb.api.exception;

public class BadRequestException extends AbstractException {

    public BadRequestException(String descricao) {
        super("BadRequest", descricao);
    }
}