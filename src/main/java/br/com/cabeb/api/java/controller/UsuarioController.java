package br.com.cabeb.api.java.controller;

import br.com.cabeb.api.java.DTO.UsuarioDTO;
import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private ModelMapper modelMapper;

    private UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDTO.class);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = this.modelMapper.map(usuarioDTO, Usuario.class);
        usuario = this.service.criarUsuario(usuario);

        return new ResponseEntity<UsuarioDTO>(toUsuarioDTO(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UsuarioDTO> obterTodosUsuarios() {
        return this.service.obterTodosUsuarios()
                .stream()
                .map(this::toUsuarioDTO)
                .collect(Collectors.toList());
    }
}
