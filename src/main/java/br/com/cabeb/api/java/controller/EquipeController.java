package br.com.cabeb.api.java.controller;

import br.com.cabeb.api.java.DTO.EquipeDTO;
import br.com.cabeb.api.java.DTO.UsuarioDTO;
import br.com.cabeb.api.java.entity.Equipe;
import br.com.cabeb.api.java.entity.Usuario;
import br.com.cabeb.api.java.service.IEquipeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipe")
public class EquipeController extends AbstractController {

    private final IEquipeService service;

    public EquipeController(ModelMapper modelMapper, IEquipeService service) {
        super(modelMapper);
        this.service = service;
    }

    @GetMapping("/integrantes/{perfilId}")
    public List<EquipeDTO> obterTodasEquipes(@PathVariable Long perfilId) {
        return this.service.obterTodasEquipes(perfilId)
                .stream()
                .map(equipe -> map(equipe, EquipeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDTO> obterIntegrantePorId(@PathVariable Long id) {
        Equipe integrante = this.service.bucarIntegrantePorId(id);
        return new ResponseEntity<>(this.map(integrante, EquipeDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipeDTO> criarIntegranteEquipe(@RequestBody EquipeDTO integranteDTO) {

        Equipe integrante = this.map(integranteDTO, Equipe.class);
        integrante = this.service.criarIntegranteEquipe(integrante);

        return new ResponseEntity<>(this.map(integrante, EquipeDTO.class), HttpStatus.CREATED);
    }
}
