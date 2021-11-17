package br.gov.sp.fatec.finances.repositories;

import br.gov.sp.fatec.finances.models.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovementsRepository extends JpaRepository<Movements, Long> {
    Optional<Movements> findTopByOrderByIdAsc();
    List<Movements> findAllByAccount_Id(Long id);
}
