package br.com.cabeb.api.service.impl;

import br.com.cabeb.api.entity.Equipe;
import br.com.cabeb.api.entity.PerfilEquipe;
import br.com.cabeb.api.exception.NotFoundException;
import br.com.cabeb.api.lib.Validar;
import br.com.cabeb.api.repository.EquipeRepository;
import br.com.cabeb.api.repository.PerfilRepository;
import br.com.cabeb.api.service.EquipeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeServiceImpl implements EquipeService {

    private final PerfilRepository perfilRepository;
    private final EquipeRepository repository;

    public EquipeServiceImpl(PerfilRepository perfilRepository, EquipeRepository repository) {
        this.perfilRepository = perfilRepository;
        this.repository = repository;
    }

    @Override
    public List<Equipe> obterTodasEquipes(Long id) {
        return this.repository.findAllByPerfilEquipe_Id(id);
    }

    @Override
    public List<PerfilEquipe> obterTodosPerfis() {
        return this.perfilRepository.findAll();
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

        integrante.setCpf(integranteAtualizado.getCpf());
        integrante.setCep(integranteAtualizado.getCep());
        integrante.setNome(integranteAtualizado.getNome());
        integrante.setEmail(integranteAtualizado.getEmail());
        integrante.setNumero(integranteAtualizado.getNumero());
        integrante.setEndereco(integranteAtualizado.getEndereco());
        integrante.setTelefone(integranteAtualizado.getTelefone());
        integrante.setMatricula(integranteAtualizado.getMatricula());
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
