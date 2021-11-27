package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.controllers.view.View;
import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;
import br.gov.sp.fatec.finances.services.MovementsService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/movements")
@CrossOrigin
public class MovementsController {
    @Autowired
    MovementsService movementsService;

    @PostMapping(value = "new")
    @JsonView(View.Movements.class)
    public Movements createMovement(@RequestBody MovementsDTO movementsDTO) {
        return movementsService.newMovement(movementsDTO);
    }

    @GetMapping(value = "listAllMovements/{id}")

    public List<MovementsDTO> listAllMovements(@PathVariable("id") Long id) {
        return movementsService.listAllMovementsByAccount(id);
    }

    @GetMapping(value = "listAllMovementsByType/{id}/{type}")
    public List<MovementsDTO> listAllMovementsByType(@PathVariable("id") Long id, @PathVariable("type") String type){
        return movementsService.listAllMovementsByType(id, type);
    }

    @GetMapping(value = "listAllMovementsByType/{type}")
    public List<MovementsDTO> listAllMovementsByType(@PathVariable("type") String type){
        return movementsService.listAllMovementsByType(type);
    }

    @GetMapping("Sum/{flow}")
    public Double getSumByValue(@PathVariable("flow") String flow) throws Exception {
        return movementsService.sumByFlow(flow);
    }

    @GetMapping("Sum/{flow}/{account}")
    public Double getSumByValue(@PathVariable("flow") String flow, @PathVariable("account") Long account) throws Exception {
        return movementsService.sumByFlow(flow, account);
    }

}
