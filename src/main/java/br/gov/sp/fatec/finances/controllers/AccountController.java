package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.controllers.view.View;
import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.dtos.AccountDTO;
import br.gov.sp.fatec.finances.services.AccountService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
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


}
