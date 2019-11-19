package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.AuthenticationDto;
import br.com.senac.nikoniko.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthController {

    private AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationDto authenticationDto) {
        try {
            return ok(authenticationService.authenticate(authenticationDto.getEmail(), authenticationDto.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
