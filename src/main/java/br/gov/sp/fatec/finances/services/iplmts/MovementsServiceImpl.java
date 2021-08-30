package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;
import br.gov.sp.fatec.finances.repositories.MovementsRepository;
import br.gov.sp.fatec.finances.services.AccountService;
import br.gov.sp.fatec.finances.services.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    MovementsRepository movementsRepository;
    @Autowired
    AccountService accountService;

    public Movements newMovement(MovementsDTO movementsDTO) {
        final var account = accountService.getAccountById(movementsDTO.getAccountId());
        Movements movements = new Movements();
        movements.setFlow(movementsDTO.getFlow());
        movements.setType(movementsDTO.getType());
        movements.setValue(movementsDTO.getValue());
        account.setCurrentBalance(account.getCurrentBalance() + movementsDTO.getValue());
        movements.setAccount(account);
        return movementsRepository.save(movements);
    }
}
