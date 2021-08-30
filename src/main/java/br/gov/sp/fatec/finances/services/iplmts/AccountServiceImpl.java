package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.dtos.AccountDTO;
import br.gov.sp.fatec.finances.repositories.AccountRepository;
import br.gov.sp.fatec.finances.services.AccountService;
import br.gov.sp.fatec.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public Account newAccount(AccountDTO accountDTO) {
        final var user  = userService.getUserById(accountDTO.getUserID());
        final var account = new Account();

        account.setUser(user);
        account.setInitialBalance(accountDTO.getInitialBalance());
        account.setCurrentBalance(accountDTO.getCurrentBalance());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
