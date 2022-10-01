package br.com.cabeb.api.java.repository;

import br.com.cabeb.api.java.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    Usuario findByUsuario(String usuario);
}
