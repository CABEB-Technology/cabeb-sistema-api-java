package br.com.cabeb.api.java.service;

import br.com.cabeb.api.java.entity.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> obterTodasEquipes(Long id);
    Equipe criarIntegranteEquipe(Equipe novoIntegrante);
    Equipe bucarIntegrantePorId(Long id);
    Equipe atualizarIntegrante(Long id, Equipe integranteAtualizado);
    void deletarIntegrante(Long id);
}
