package br.com.cabeb.api.service;

import br.com.cabeb.api.entity.Equipe;

import java.util.List;

public interface EquipeService {

    List<Equipe> obterTodasEquipes(Long id);
    Equipe criarIntegranteEquipe(Equipe novoIntegrante);
    Equipe bucarIntegrantePorId(Long id);
    Equipe atualizarIntegrante(Long id, Equipe integranteAtualizado);
    void deletarIntegrante(Long id);
}
