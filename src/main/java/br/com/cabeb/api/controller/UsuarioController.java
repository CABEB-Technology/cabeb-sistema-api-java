package br.com.cabeb.api.controller;

import br.com.cabeb.api.DTO.UsuarioDTO;
import br.com.cabeb.api.entity.Usuario;
import br.com.cabeb.api.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service, ModelMapper modelMapper) {
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
