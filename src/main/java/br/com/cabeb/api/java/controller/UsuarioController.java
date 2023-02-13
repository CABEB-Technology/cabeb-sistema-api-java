package br.com.cabeb.api.java.controller;

import br.com.cabeb.api.java.DTO.UsuarioDTO;
import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.service.UsuarioService;
import br.com.cabeb.api.java.service.impl.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

    private final IUsuarioService service;

    public UsuarioController(IUsuarioService service, ModelMapper modelMapper) {
        super(modelMapper);
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = this.map(usuarioDTO, Usuario.class);
        usuario = this.service.criarUsuario(usuario);

        return new ResponseEntity<>(this.map(usuario, UsuarioDTO.class), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UsuarioDTO> obterTodosUsuarios() {
        return this.service.obterTodosUsuarios()
                .stream()
                .map(usuario -> map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterUsuario(@PathVariable Long id) {
        Usuario usuario = this.service.obterUsuarioPorId(id);
        return new ResponseEntity<>(this.map(usuario, UsuarioDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarUsuario(@PathVariable Long id) {
        this.service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
