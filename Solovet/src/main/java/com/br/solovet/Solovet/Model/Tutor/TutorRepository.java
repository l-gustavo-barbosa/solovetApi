package com.br.solovet.Solovet.Model.Tutor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Page<Tutor> findByStatusTrue(Pageable pageable);
        Page<Tutor> findByVeterinarioId(Long veterinarioId, Pageable pageable);


}
