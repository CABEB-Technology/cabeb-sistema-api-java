package br.com.cabeb.api.java.integration;

import br.com.cabeb.api.java.DTO.UsuarioDTO;
import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.repository.UsuarioRepository;
import br.com.cabeb.api.java.security.DTO.JwtRequestDTO;
import br.com.cabeb.api.java.service.UsuarioService;
import br.com.cabeb.api.java.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsuarioIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModelMapper modelMapper;

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

    private UsuarioDTO toUsuarioDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Test
    void deveCriarUsuario() throws Exception {
        Usuario usuario = TestUtils.criarUsuario();
        UsuarioDTO usuarioDTO = this.toUsuarioDto(usuario);

        RequestBuilder request = MockMvcRequestBuilders.post("/usuario")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.asJsonString(usuarioDTO))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void deveAutenticarUsuario() throws Exception {
        JwtRequestDTO usuario = new JwtRequestDTO();

        usuario.setEmail("victor@gmail.com");
        usuario.setSenha("12345678");

        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.asJsonString(usuario))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void deveReceberExcecaoSenha() throws Exception {
        JwtRequestDTO usuario = new JwtRequestDTO();

        usuario.setEmail("victor@gmail.com");
        usuario.setSenha("123456");

        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.asJsonString(usuario))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void deveReceberExcecaoEmail() throws Exception {
        JwtRequestDTO usuario = new JwtRequestDTO();

        usuario.setEmail("");
        usuario.setSenha("12345678");

        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.asJsonString(usuario))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void deveReceberExcecaoEmailNaoEncontrado() throws Exception {
        JwtRequestDTO usuario = new JwtRequestDTO();

        usuario.setEmail("miguel@gmail.com");
        usuario.setSenha("12345678");

        RequestBuilder request = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtils.asJsonString(usuario))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
