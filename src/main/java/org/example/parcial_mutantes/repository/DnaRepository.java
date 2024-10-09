package org.example.parcial_mutantes.repository;

import org.example.parcial_mutantes.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
    long countByIsMutant(boolean isMutant);
}

