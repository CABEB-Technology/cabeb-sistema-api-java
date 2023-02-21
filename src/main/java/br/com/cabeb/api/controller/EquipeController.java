package br.com.cabeb.api.controller;

import br.com.cabeb.api.DTO.EquipeDTO;
import br.com.cabeb.api.entity.Equipe;
import br.com.cabeb.api.service.EquipeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipe")
public class EquipeController extends AbstractController {

    private final EquipeService service;

    public EquipeController(ModelMapper modelMapper, EquipeService service) {
        super(modelMapper);
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EquipeDTO> criarIntegranteEquipe(@RequestBody EquipeDTO integranteDTO) {

        Equipe integrante = this.map(integranteDTO, Equipe.class);
        integrante = this.service.criarIntegranteEquipe(integrante);

        return new ResponseEntity<>(this.map(integrante, EquipeDTO.class), HttpStatus.CREATED);
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

    @PutMapping("/{id}")
    public ResponseEntity<EquipeDTO> atualizarIntegrante(@PathVariable Long id, @RequestBody EquipeDTO integranteDTO) {

        Equipe integrante = this.map(integranteDTO, Equipe.class);
        integrante = this.service.atualizarIntegrante(id, integrante);

        return new ResponseEntity<>(this.map(integrante, EquipeDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarIntegrante(@PathVariable Long id) {
        this.service.deletarIntegrante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
