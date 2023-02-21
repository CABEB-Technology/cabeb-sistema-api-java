package br.com.cabeb.api.repository;

import br.com.cabeb.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    Usuario findByUsuario(String usuario);
}
