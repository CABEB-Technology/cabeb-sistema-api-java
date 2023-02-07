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
public class UsuarioController {

    private final IUsuarioService service;
    private final ModelMapper modelMapper;

    public UsuarioController(UsuarioService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    private UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDTO.class);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = this.modelMapper.map(usuarioDTO, Usuario.class);
        usuario = this.service.criarUsuario(usuario);

        return new ResponseEntity<>(toUsuarioDTO(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UsuarioDTO> obterTodosUsuarios() {
        return this.service.obterTodosUsuarios()
                .stream()
                .map(this::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterUsuario(@PathVariable Long id) {
        Usuario usuario = this.service.obterUsuarioPorId(id);
        return new ResponseEntity<>(toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarUsuario(@PathVariable Long id) {
        this.service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
