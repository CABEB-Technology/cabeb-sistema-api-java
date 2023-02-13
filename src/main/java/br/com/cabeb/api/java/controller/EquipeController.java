package br.com.cabeb.api.java.controller;

import br.com.cabeb.api.java.service.impl.IEquipeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipe")
public class EquipeController extends AbstractController {

    private final IEquipeService service;

    public EquipeController(ModelMapper modelMapper, IEquipeService service) {
        super(modelMapper);
        this.service = service;
    }
}
