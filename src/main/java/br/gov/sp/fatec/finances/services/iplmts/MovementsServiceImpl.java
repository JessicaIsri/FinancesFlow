package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;
import br.gov.sp.fatec.finances.repositories.AccountRepository;
import br.gov.sp.fatec.finances.repositories.MovementsRepository;
import br.gov.sp.fatec.finances.services.AccountService;
import br.gov.sp.fatec.finances.services.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    MovementsRepository movementsRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Movements newMovement(MovementsDTO movementsDTO) {
        final var account = accountService.getAccountById(movementsDTO.getAccountId());
        Movements movements = new Movements();
        movements.setFlow(movementsDTO.getFlow());
        movements.setType(movementsDTO.getType());
        movements.setValue(movementsDTO.getValue());
        account.setCurrentBalance(account.getCurrentBalance() + movementsDTO.getValue());
        movements.setAccount(account);

        accountRepository.save(account);
        var movementsSaved = movementsRepository.save(movements);
        return movementsSaved;
    }
}
