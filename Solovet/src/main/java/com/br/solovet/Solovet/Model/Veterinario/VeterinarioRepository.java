package com.br.solovet.Solovet.Model.Veterinario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    DadosListagem findByEmail(String email);
}
