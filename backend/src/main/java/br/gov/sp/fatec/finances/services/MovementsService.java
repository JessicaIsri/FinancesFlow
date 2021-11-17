package br.gov.sp.fatec.finances.services;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;

import java.util.List;

public interface MovementsService {
    public Movements newMovement(MovementsDTO movementsDTO);
    public List<MovementsDTO> listAllMovementsByAccount(Long id);
}
