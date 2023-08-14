package com.br.solovet.Solovet.Controller;

import com.br.solovet.Solovet.Model.Atividade.Atividade;
import com.br.solovet.Solovet.Model.Atividade.AtividadeRepository;
import com.br.solovet.Solovet.Model.Atividade.DadosCadastro;
import com.br.solovet.Solovet.Model.Atividade.DadosListagemAtividades;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades")
public class AtividadesController {
    @Autowired
    private AtividadeRepository repository;


    @PostMapping("{veterinarioId}/{tutorId}/{animalId}/nova_Atividade")
    public ResponseEntity cadastrarAtividade(@Valid @RequestBody DadosCadastro dados,
                                   @PathVariable Long veterinarioId, @PathVariable Long tutorId,
                                        @PathVariable Long animalId){
        var atividade = new Atividade(dados);
        atividade.setVeterinarioId(veterinarioId);
        atividade.setTutorId(tutorId);
        atividade.setAnimalId(animalId);
        repository.save(atividade);
        return ResponseEntity.ok(atividade);
    }

    @GetMapping("veterinario/{veterinarioId}")
    public ResponseEntity<Page<DadosListagemAtividades>> listaAtividades(@PageableDefault(size = 10, sort = {"status"}) Pageable pageable,
                                                                         @PathVariable Long veterinarioId){
        var page = repository.findByVeterinarioId(veterinarioId, pageable).map(DadosListagemAtividades::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("tutor/{tutorId}")
    public ResponseEntity<Page<DadosListagemAtividades>> listaAtividadesTutor(@PageableDefault(size = 10, sort = {"status"}) Pageable pageable,
                                                                         @PathVariable Long tutorId){
        var page = repository.findByTutorId(tutorId, pageable).map(DadosListagemAtividades::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("animal/{animalId}")
    public ResponseEntity<Page<DadosListagemAtividades>> listaAtividadesAnimal(@PageableDefault(size = 10, sort = {"status"}) Pageable pageable,
                                                                         @PathVariable Long animalId){
        var page = repository.findByAnimalId(animalId, pageable).map(DadosListagemAtividades::new);
        return ResponseEntity.ok(page);
    }

}
