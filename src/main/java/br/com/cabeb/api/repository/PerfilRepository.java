package br.com.cabeb.api.repository;

import br.com.cabeb.api.entity.PerfilEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEquipe, Long> {
}
