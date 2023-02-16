package br.com.cabeb.api.java.lib;

import br.com.cabeb.api.java.entity.AbstractModel;
import br.com.cabeb.api.java.exception.BadRequestException;

import java.time.LocalDate;

public class Validar {

    public static <T extends AbstractModel> void validarObjeto(T objeto) {

        if (!CpfValidate.isCPF(objeto.getCpf())) throw new BadRequestException("Cpf inválido");
        if (!EmailValidate.isEmail(objeto.getEmail())) throw new BadRequestException("E-mail inválido");
        if (objeto.getDataNascimento().isAfter(LocalDate.now())) throw new BadRequestException("Data de nascimento não pode ser maior que a data atual");
    }
}
