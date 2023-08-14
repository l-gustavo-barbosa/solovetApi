package com.br.solovet.Solovet.Model.Atividade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    Page<Atividade> findByVeterinarioId(Long veterinarioId, Pageable pageable);

    Page<Atividade> findByTutorId(Long tutorId, Pageable pageable);

    Page<Atividade> findByAnimalId(Long animalId, Pageable pageable);



}
