package br.com.cabeb.api.java.service.impl;

import br.com.cabeb.api.java.entity.Equipe;
import br.com.cabeb.api.java.exception.NotFoundException;
import br.com.cabeb.api.java.repository.EquipeRepository;
import br.com.cabeb.api.java.service.IEquipeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeServiceImpl implements IEquipeService {

    private final EquipeRepository repository;

    public EquipeServiceImpl(EquipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Equipe> obterTodasEquipes(Long id) {
        return this.repository.findAllByPerfilEquipe_Id(id);
    }

    @Override
    public Equipe criarIntegranteEquipe(Equipe integrante) {

        integrante.setCriado(LocalDateTime.now());
        integrante.setModificado(LocalDateTime.now());

        return this.repository.save(integrante);
    }

    @Override
    public Equipe bucarIntegrantePorId(Long id) {
        Optional<Equipe> integrante = this.repository.findById(id);
        return integrante.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}