package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;
import br.gov.sp.fatec.finances.services.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movements")
@CrossOrigin
public class MovementsController {
    @Autowired
    MovementsService movementsService;

    @PostMapping(value = "new")
    public Movements createMovement(@RequestBody MovementsDTO movementsDTO) {
        return movementsService.newMovement(movementsDTO);
    }

}
