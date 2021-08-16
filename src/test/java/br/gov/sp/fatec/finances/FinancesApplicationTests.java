package br.gov.sp.fatec.finances;
import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.Moviments;
import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.repositories.AccountRepository;
import br.gov.sp.fatec.finances.repositories.MovimentsRepository;
import br.gov.sp.fatec.finances.repositories.UserRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinancesApplicationTests {

    @Autowired
    private MovimentsRepository movimentsRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    @Order(1)
    void insertNewUser() {
        User user = new User();
        user.setEmail("teste@teste.com");
        user.setName("Teste Usuário");
        user.setPassword("mudar!@#");

        var savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    @Order(2)
    void insertNewAccount() {
        Account account = new Account();
        Optional<User> user = userRepository.findTopByOrderByIdAsc();
        account.setInitialBalance(10000.0);
        account.setCurrentBalance(11000.0);
        account.setUser(user.get());

        var savedAccount = accountRepository.save(account);
        assertNotNull(savedAccount);
        assertEquals(account.getUser(), savedAccount.getUser());
    }

    @Test
    @Order(3)
    void insertNewMoviment() throws Exception {
        Moviments movimentsMap = accountRepository.findTopByOrderByIdAsc().map(account1 -> {
            Moviments moviments = new Moviments();
            moviments.setAccount(account1);
            moviments.setType("Alimentação");
            moviments.setFlow("OUT");
            moviments.setValue(100.0);
            return moviments;
        }).orElseThrow(Exception::new);
        Moviments movimentsSaved = movimentsRepository.save(movimentsMap);
        assertNotNull(movimentsSaved);
    }

    @Test
    @Order(4)
    void updateMoviment() throws Exception {
        Moviments moviments = movimentsRepository.findTopByOrderByIdAsc().map(moviments1 -> {
            moviments1.setType("Farmacia");
            return movimentsRepository.save(moviments1);
        }).orElseThrow(Exception::new);
        assertEquals(moviments.getType(), "Farmacia");
    }

    @Test
    @Order(5)
    void updateAccount() throws Exception {
        Account account = accountRepository.findTopByOrderByIdAsc().map(account1 -> {
            account1.setCurrentBalance(account1.getCurrentBalance() + 100);
            return accountRepository.save(account1);
        }).orElseThrow(Exception::new);
        assertEquals(account.getCurrentBalance(), 11100.0);
    }

    @Test
    @Order(6)
    void updateUser() throws Exception {
        User user = userRepository.findTopByOrderByIdAsc().map(user1 -> {
            user1.setName("Teste2");
            return userRepository.save(user1);
        }).orElseThrow(Exception::new);
        assertEquals(user.getName(), "Teste2");
    }

    @Test
    @Order(7)
    void deleteMoviment() {
        movimentsRepository.deleteById(1L);
        Optional<Moviments> movimentsOptional = movimentsRepository.findTopByOrderByIdAsc();
        assertFalse(movimentsOptional.isPresent());
    }

    @Test
    @Order(8)
    void deleteAccount() {
        accountRepository.deleteById(1L);
        Optional<Account> accountOptional = accountRepository.findTopByOrderByIdAsc();
        assertFalse(accountOptional.isPresent());
    }

    @Test
    @Order(9)
    void deleteUser() {
        userRepository.deleteById(1L);
        Optional<User> userOptional = userRepository.findTopByOrderByIdAsc();
        assertFalse(userOptional.isPresent());
    }



}
