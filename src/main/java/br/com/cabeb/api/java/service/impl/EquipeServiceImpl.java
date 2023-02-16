package br.com.cabeb.api.java.service.impl;

import br.com.cabeb.api.java.entity.Equipe;
import br.com.cabeb.api.java.exception.NotFoundException;
import br.com.cabeb.api.java.lib.Validar;
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
    public Equipe criarIntegranteEquipe(Equipe novoIntegrante) {

        Validar.validarObjeto(novoIntegrante);

        novoIntegrante.setCriado(LocalDateTime.now());
        novoIntegrante.setModificado(LocalDateTime.now());

        return this.repository.save(novoIntegrante);
    }

    @Override
    public Equipe bucarIntegrantePorId(Long id) {
        Optional<Equipe> integrante = this.repository.findById(id);
        return integrante.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public Equipe atualizarIntegrante(Long id, Equipe integranteAtualizado) {
        Validar.validarObjeto(integranteAtualizado);
        Equipe integrante = this.bucarIntegrantePorId(id);

        integrante.setNome(integranteAtualizado.getNome());
        integrante.setCpf(integranteAtualizado.getCpf());
        integrante.setEmail(integranteAtualizado.getEmail());
        integrante.setMatricula(integranteAtualizado.getMatricula());
        integrante.setEndereco(integranteAtualizado.getEndereco());
        integrante.setTelefone(integranteAtualizado.getTelefone());
        integrante.setCargaHoraria(integranteAtualizado.getCargaHoraria());
        integrante.setPerfilEquipe(integranteAtualizado.getPerfilEquipe());

        integrante.setDataNascimento(integranteAtualizado.getDataNascimento());
        integrante.setModificado(LocalDateTime.now());

        return this.repository.save(integrante);
    }

    @Override
    public void deletarIntegrante(Long id) {
        boolean exists = this.repository.existsById(id);
        if(exists) this.repository.deleteById(id);
    }
}
