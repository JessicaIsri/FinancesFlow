package br.gov.sp.fatec.finances.repositories;

import br.gov.sp.fatec.finances.models.Moviments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovimentsRepository extends JpaRepository<Moviments, Long> {
    Optional<Moviments> findTopByOrderByIdAsc();
}
