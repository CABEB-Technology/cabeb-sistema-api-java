package br.com.cabeb.api.java.unit;

import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.exception.BadRequestException;
import br.com.cabeb.api.java.repository.UsuarioRepository;
import br.com.cabeb.api.java.service.UsuarioService;
import br.com.cabeb.api.java.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UsuarioUnitTest {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    private final Usuario usuario1 = new Usuario();

    @BeforeEach
    void init() {
        usuario1.setUsuario("Victor");
        usuario1.setCpf("63829559062");
        usuario1.setSenha("12345678");
        usuario1.setEmail("victor@gmail.com");

        this.service.criarUsuario(usuario1);
    }

    @AfterEach
    void tearDown() {
        this.repository.deleteAll();
    }

    @Test
    void deveCriarUsuario() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        Usuario usuarioSalvo = this.service.criarUsuario(usuario);
        Usuario usuarioBanco = this.repository.findById(usuarioSalvo.getId()).get();

        // then
        assertEquals(usuarioSalvo.getUsuario(), usuarioBanco.getUsuario());
        assertEquals(usuarioSalvo.getCpf(), usuarioBanco.getCpf());
        assertEquals(usuarioSalvo.getEmail(), usuarioBanco.getEmail());
        assertEquals(usuarioSalvo.getSenha(), usuarioBanco.getSenha());
    }

    @Test
    void deveReceberExcecaoCPF() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        usuario.setCpf("51255973438");

        // then
        assertThrows(BadRequestException.class, () -> this.service.criarUsuario(usuario));
    }

    @Test
    void deveReceberExcecaoEmail() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        usuario.setEmail("test@");

        // then
        assertThrows(BadRequestException.class, () -> this.service.criarUsuario(usuario));
    }

    @Test
    void deveReceberExcecaoEmailCadastrado() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        usuario.setEmail("victor@gmail.com");

        // then
        assertThrows(BadRequestException.class, () -> this.service.criarUsuario(usuario));
    }

    @Test
    void deveReceberExcecaoSenha() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        usuario.setSenha("123456");

        // then
        assertThrows(BadRequestException.class, () -> this.service.criarUsuario(usuario));
    }

    @Test
    void deveReceberExcecaoUsuario() {
        // given
        Usuario usuario = TestUtils.criarUsuario();

        // when
        usuario.setUsuario("Victor");

        // then
        assertThrows(BadRequestException.class, () -> this.service.criarUsuario(usuario));
    }
}
