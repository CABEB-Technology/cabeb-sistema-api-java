package br.com.cabeb.api.java.utils;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUtils {

    @Autowired
    private UsuarioService service;

    public static Usuario criarUsuario() {
        Usuario usuario = new Usuario();

        usuario.setUsuario("Brendson");
        usuario.setCpf("99596634003");
        usuario.setSenha("12345678");
        usuario.setEmail("brendson@gmail.com");

        return usuario;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
