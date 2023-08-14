package com.br.solovet.Solovet.Controller;

import com.br.solovet.Solovet.Model.Tutor.DadosCadastro;
import com.br.solovet.Solovet.Model.Tutor.DadosListagemTutores;
import com.br.solovet.Solovet.Model.Tutor.Tutor;
import com.br.solovet.Solovet.Model.Tutor.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    @Autowired
    private TutorRepository repository;

    @Transactional
    @PostMapping("{veterinarioId}/novo_tutor")
    public void novoTutor(@Valid @RequestBody DadosCadastro dados, @PathVariable Long veterinarioId){
        var tutor = new Tutor(dados);
        tutor.setVeterinarioId(veterinarioId);
        repository.save(tutor);
    }

    @GetMapping("{veterinarioId}")
    public ResponseEntity<Page<DadosListagemTutores>> listaTutores(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable,
                                                                   @PathVariable Long veterinarioId){

   var page = repository.findByVeterinarioId(veterinarioId, pageable).map(DadosListagemTutores::new);

   return  ResponseEntity.ok(page);

    }
}
