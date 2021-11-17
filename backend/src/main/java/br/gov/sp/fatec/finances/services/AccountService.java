package br.gov.sp.fatec.finances.services;

import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.dtos.AccountDTO;

import java.util.List;

public interface AccountService {
    public Account newAccount(AccountDTO accountDTO);
    public void deleteAccount(Long id);
    public Account getAccountById(Long id);
    public List<Account> listAccounts(Long userId);
}
