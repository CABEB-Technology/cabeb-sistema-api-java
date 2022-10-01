package br.com.cabeb.api.java.exception;

public class NotFoundException extends AbstractException {

    public NotFoundException(String descricao) {
        super("NotFound", descricao);
    }
}
