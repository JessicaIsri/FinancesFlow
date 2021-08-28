package br.gov.sp.fatec.finances.services;

import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    public User newUser(UserDTO userDTO) throws Exception;
    public String newPassword(UserDTO userDTO) throws Exception;
    public void deleteUser(UserDTO userDTO) throws Exception;
}
