package br.com.cabeb.api.java.controller;

import org.modelmapper.ModelMapper;

public abstract class AbstractController {

    private final ModelMapper modelMapper;

    public AbstractController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, U> U map(T source, Class<U> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
