package br.gov.sp.fatec.finances;
import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.AccountDTO;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.services.AccountService;
import br.gov.sp.fatec.finances.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinancesApplicationTests {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Test
//    void testNewUser() throws Exception {
//        UserDTO userDTO = new UserDTO("Teste", "teste@teste.com", "teste!@#", false, "", null, null, null);
//        userService.newUser(userDTO);
//    }
//
//    @Test
//    void testNewPasswordNotOk() throws Exception {
//        UserDTO userDTO = new UserDTO("Teste", "teste@teste.com", "41241!@#", false, "", null, null, null);
//        assertThrows(Exception.class, () -> {userService.newPassword(userDTO);});
//    }
//
//    @Test
//    void testDelete() throws Exception {
//        UserDTO userDTO = new UserDTO("Teste4", "teste4@teste.com", "teste!@#", false, "", null, null, null);
//        userService.newUser(userDTO);
//        assertDoesNotThrow(() -> {userService.deleteUser(userDTO);});
//    }
//
//    @Test
//    void testGetUser() throws Exception {
//        UserDTO userDTO = new UserDTO("TesteGet", "testeget@teste.com", "teste!@#", false, "", null, null, null);
//        userService.newUser(userDTO);
//        User user = userService.getUserByEmailName(userDTO.getEmail(), userDTO.getName());
//        assertEquals(user.getName(), "TesteGet");
//        userService.deleteUser(userDTO);
//    }
//
//    @Test
//    void testNewAccount() throws Exception {
//        final var userDTO = new UserDTO("TesteAccount", "testeaccount@teste.com", "teste!@#", false, "", null, null, null);
//        final var user = userService.newUser(userDTO);
//        final var accountDTO = new AccountDTO(2000.0, 2000.0, user.getId());
//
//        final var savedAccount = accountService.newAccount(accountDTO);
//        assertEquals(savedAccount.getUser().getName(), userDTO.getName());
//    }
}
