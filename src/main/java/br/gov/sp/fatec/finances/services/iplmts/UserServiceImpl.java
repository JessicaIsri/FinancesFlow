package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.repositories.UserRepository;
import br.gov.sp.fatec.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User newUser(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if (optionalUser.isEmpty()) {
            User user = new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            return userRepository.save(user);
        } else {
            throw new Exception("Usuário já existe");
        }

    }
}
