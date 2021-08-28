package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/new")
    public User newUser(@RequestBody UserDTO userDto) throws Exception {
        return userService.newUser(userDto);
    }

    @PutMapping(value = "/update")
    public String updatePassword(@RequestBody UserDTO userDTO) throws Exception {
        return userService.newPassword(userDTO);
    }

    @DeleteMapping(value = "/delete")
    public void deletePassword(@RequestBody UserDTO userDTO) {

    }
}
