package br.com.senac.nikoniko.security.services;

import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.security.JwtUserFactory;
import br.com.senac.nikoniko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@Qualifier("JwtUserDetails")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(username);

        if (user.isPresent()) {
            return JwtUserFactory.create(user.get());
        }

        throw new UsernameNotFoundException("Email não encontrado.");
    }

}
