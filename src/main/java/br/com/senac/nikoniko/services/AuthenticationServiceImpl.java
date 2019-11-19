package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.AuthenticatedDto;
import br.com.senac.nikoniko.providers.JwtTokenProvider;
import br.com.senac.nikoniko.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthenticationServiceImpl(JwtTokenProvider jwtTokenProvider,
                                     UserRepository userRepository,
                                     AuthenticationManager authenticationManager,
                                     BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public AuthenticatedDto authenticate(String email, String password) {
        var user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Username " + email + "not found"));

        var roles = List.of(user.getRole().getLabel());

        bCryptPasswordEncoder.encode("password");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        return new AuthenticatedDto(user.getEmail(), jwtTokenProvider.createToken(email, roles));
    }
}
