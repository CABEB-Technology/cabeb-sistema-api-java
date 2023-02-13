package br.com.cabeb.api.java.repository;

import br.com.cabeb.api.java.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
