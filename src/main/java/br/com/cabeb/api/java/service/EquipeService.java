package br.com.cabeb.api.java.service;

import br.com.cabeb.api.java.entity.Equipe;
import br.com.cabeb.api.java.repository.EquipeRepository;
import br.com.cabeb.api.java.service.impl.IEquipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService implements IEquipeService {

    private final EquipeRepository repository;

    public EquipeService(EquipeRepository repository) {
        this.repository = repository;
    }

    public List<Equipe> obterTodasEquipes() {
        return null;
    }
}
