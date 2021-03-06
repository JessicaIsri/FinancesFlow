package br.gov.sp.fatec.finances.services.iplmts;

import br.gov.sp.fatec.finances.models.Autorization;
import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.repositories.UserRepository;
import br.gov.sp.fatec.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User newUser(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmailAndName(userDTO.getEmail(), userDTO.getName());
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

    public String newPassword(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmailAndName(userDTO.getEmail(), userDTO.getName());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userDTO.getForgetPassword()) {
                user.setPassword(userDTO.getNewPassword());
            } else {
                if (userDTO.getPassword().equals(user.getPassword())) {
                    user.setPassword(userDTO.getNewPassword());
                } else {
                    throw new Exception("As senhas não coincidem");
                }
            }
            userRepository.save(user);
            return "Senha Atualizada sucesso";
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }

    public void deleteUser(UserDTO userDTO) throws Exception {
        Optional<User> userOptional = userRepository.findByEmailAndName(userDTO.getEmail(), userDTO.getName());
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    public User getUserByEmailName(String email, String name) throws Exception {
        Optional<User> optionalUser = userRepository.findByEmailAndName(email, name);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }

    public User getUserByName(String name) {
        return userRepository.findTop1ByNameOrEmail(name, name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findTop1ByNameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário "
                    + username
                    + " não encontrado");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(username).password(user.getPassword())
                .authorities(user.getAutorizations()
                        .stream().map(Autorization::getNome)
                        .collect(Collectors.toList())
                        .toArray(new String[user.getAutorizations().size()])).
                build();

    }
}
