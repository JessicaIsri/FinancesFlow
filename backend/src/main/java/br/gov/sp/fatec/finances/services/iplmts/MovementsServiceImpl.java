package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.MovementsDTO;
import br.gov.sp.fatec.finances.repositories.AccountRepository;
import br.gov.sp.fatec.finances.repositories.MovementsRepository;
import br.gov.sp.fatec.finances.services.AccountService;
import br.gov.sp.fatec.finances.services.MovementsService;
import br.gov.sp.fatec.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    MovementsRepository movementsRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<MovementsDTO> listAllMovementsByAccount(Long id) {
        return movementsRepository.findAllByAccount_Id(id).stream().map(this::toDto).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<MovementsDTO> listAllMovementsByType(Long id, String type) {
        return movementsRepository.findAllByFlowAndAccount_Id(type,id).stream().map(this::toDto).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<MovementsDTO> listAllMovementsByType(String type) {
        return movementsRepository.findAllByFlow(type).stream().map(this::toDto).collect(Collectors.toList());
    }

    private MovementsDTO toDto(Movements movements) {
        var movementsDTO = new MovementsDTO();
        movementsDTO.setAccountId(movements.getAccount().getId());
        movementsDTO.setType(movements.getType());
        movementsDTO.setFlow(movements.getFlow());
        movementsDTO.setValue(movements.getValue());

        return movementsDTO;
    }

    public Double sumByFlow(String flow) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByName(auth.getName());
        return movementsRepository.sumByFlow(flow, user.getId());
    }

    public Double sumByFlow(String flow, Long id) throws Exception {
        return movementsRepository.sumByFlowByAccount(flow, id);
    }
}
