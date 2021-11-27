package br.gov.sp.fatec.finances.services;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;

import java.util.List;

public interface MovementsService {
    public Movements newMovement(MovementsDTO movementsDTO);
    public List<MovementsDTO> listAllMovementsByAccount(Long id);
    public List<MovementsDTO> listAllMovementsByType(Long id, String type);
    public List<MovementsDTO> listAllMovementsByType(String type);
    public Double sumByFlow(String flow) throws Exception;
    public Double sumByFlow(String flow, Long id) throws Exception;


}
