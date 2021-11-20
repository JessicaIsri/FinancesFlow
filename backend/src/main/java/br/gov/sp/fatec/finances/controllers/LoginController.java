package br.gov.sp.fatec.finances.controllers;

import br.gov.sp.fatec.finances.models.User;
import br.gov.sp.fatec.finances.models.dtos.UserDTO;
import br.gov.sp.fatec.finances.utils.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired

    private AuthenticationManager authenticationManager;

    @PostMapping(path = "api/login")
    public UserDTO login(@RequestBody UserDTO login)
            throws JsonProcessingException {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        login.setPassword(null);
        login.setToken(JwtUtils.generateToken(auth));
        return login;
    }
}
