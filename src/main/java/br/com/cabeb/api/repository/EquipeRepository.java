package br.com.cabeb.api.repository;

import br.com.cabeb.api.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    List<Equipe> findAllByPerfilEquipe_Id(Long id);
}
