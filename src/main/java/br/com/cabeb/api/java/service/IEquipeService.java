package br.com.cabeb.api.java.service;

import br.com.cabeb.api.java.entity.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> obterTodasEquipes(Long id);
    Equipe criarIntegranteEquipe(Equipe integrante);
}
