package br.gov.sp.fatec.finances;
import br.gov.sp.fatec.finances.models.Account;
import br.gov.sp.fatec.finances.models.Movements;
import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.repositories.AccountRepository;
import br.gov.sp.fatec.finances.repositories.MovimentsRepository;
import br.gov.sp.fatec.finances.repositories.UserRepository;
import br.gov.sp.fatec.finances.services.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinancesApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void testNewUser() throws Exception {
        UserDTO userDTO = new UserDTO("Teste", "teste@teste.com", "teste!@#", false, "");
        userService.newUser(userDTO);
    }

    @Test
    void testNewPasswordNotOk() throws Exception {
        UserDTO userDTO = new UserDTO("Teste", "teste@teste.com", "41241!@#", false, "");
        assertThrows(Exception.class, () -> {userService.newPassword(userDTO);});
    }

    @Test
    void testNewPassword() throws Exception {
        UserDTO userDTO = new UserDTO("Teste4", "teste4@teste.com", "teste!@#", false, "");
        userService.newUser(userDTO);

        assertDoesNotThrow(() -> {userService.deleteUser(userDTO);});
    }
}
