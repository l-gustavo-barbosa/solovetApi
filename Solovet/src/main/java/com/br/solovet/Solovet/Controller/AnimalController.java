package com.br.solovet.Solovet.Controller;

import com.br.solovet.Solovet.Model.Animal.Animal;
import com.br.solovet.Solovet.Model.Animal.AnimalRepository;
import com.br.solovet.Solovet.Model.Animal.DadosCadastro;
import com.br.solovet.Solovet.Model.Animal.DadosListagemAnimais;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalRepository repository;

    @Transactional
    @PostMapping("{tutorId}/novo_Animal")
    public void cadastroAnimal(@Valid @RequestBody DadosCadastro dados, @PathVariable Long tutorId){
        var animal = new Animal(dados);
        animal.setTutorId(tutorId);
        repository.save(animal);

    }

    @GetMapping("{tutorId}")
    public ResponseEntity<Page<DadosListagemAnimais>> listaAnimais(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable,
                                                     @PathVariable Long tutorId){
        var page = repository.findByTutorId(tutorId, pageable).map(DadosListagemAnimais::new);
        return ResponseEntity.ok(page);
    }

}
