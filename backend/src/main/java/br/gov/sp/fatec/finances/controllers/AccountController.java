package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.controllers.view.View;
import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.dtos.AccountDTO;
import br.gov.sp.fatec.finances.services.AccountService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/account")
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/new")
    @JsonView(View.Account.class)
    public Account createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.newAccount(accountDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping(value = "listAll/{id}")
    @JsonView(View.Account.class)
    public List<Account> listAccount(@PathVariable("id") String id) {
        return accountService.listAccounts(id);
    }

    @GetMapping(value = "{id}")
    @JsonView({View.Account.class})
    public Account getAccount(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }



}
