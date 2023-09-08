package com.br.solovet.Solovet.Controller;

import com.br.solovet.Solovet.Model.Veterinario.DadosCadastro;
import com.br.solovet.Solovet.Model.Veterinario.Veterinario;
import com.br.solovet.Solovet.Model.Veterinario.VeterinarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    VeterinarioRepository repository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro dadosCadastro){
        var veterinario = new Veterinario(dadosCadastro);
        repository.save(veterinario);
        return ResponseEntity.ok(dadosCadastro);
    }

    @GetMapping("/{emailVeterinario}")
    public ResponseEntity nomeVeterinario(@PathVariable String emailVeterinario){
        var veterinario = repository.findByEmail(emailVeterinario);
        return ResponseEntity.ok(veterinario);
    }


}
