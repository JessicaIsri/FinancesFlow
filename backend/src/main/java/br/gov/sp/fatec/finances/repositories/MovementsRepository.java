package br.gov.sp.fatec.finances.repositories;

import br.gov.sp.fatec.finances.models.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovementsRepository extends JpaRepository<Movements, Long> {
    Optional<Movements> findTopByOrderByIdAsc();
    List<Movements> findAllByAccount_Id(Long id);
    List<Movements> findAllByFlowAndAccount_Id(String type,Long id);
    List<Movements> findAllByFlow(String type);
    @Query(nativeQuery = true, value = "SELECT sum(mv_value) from mv_moviments where mv_flow = ?1 and ac_id in (select ac_id from ac_account where us_id = ?2)")
    Double sumByFlow(String flow, Long id);

    @Query(nativeQuery = true, value = "SELECT sum(mv_value) from mv_moviments where mv_flow = ?1 and ac_id = ?2")
    Double sumByFlowByAccount(String flow, Long id);

}
