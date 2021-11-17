package br.gov.sp.fatec.finances.services;

import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
    public User newUser(UserDTO userDTO) throws Exception;
    public String newPassword(UserDTO userDTO) throws Exception;
    public void deleteUser(UserDTO userDTO) throws Exception;
    public User getUserByEmailName(String email, String name) throws Exception;
    public User getUserById(Long id);
}
