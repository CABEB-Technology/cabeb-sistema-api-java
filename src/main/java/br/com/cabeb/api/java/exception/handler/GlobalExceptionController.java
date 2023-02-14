package br.com.cabeb.api.java.exception.handler;

import br.com.cabeb.api.java.exception.BadRequestException;
import br.com.cabeb.api.java.exception.message.ErrorMessage;
import br.com.cabeb.api.java.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessage> badRequest(BadRequestException ex) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getErro(), ex.getDescricao()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFound(NotFoundException ex) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getErro(), ex.getDescricao()), HttpStatus.NOT_FOUND);
    }
}