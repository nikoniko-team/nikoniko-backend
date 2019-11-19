package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.AuthenticatedDto;

public interface AuthenticationService {
    AuthenticatedDto authenticate(String email, String password);
}
