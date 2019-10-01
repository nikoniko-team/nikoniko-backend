package br.com.senac.nikoniko.services;


import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        log.info("Persistindo usuário: {}", user);
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        log.info("Buscando usuário pelo nome {}", name);
        return Optional.ofNullable(this.userRepository.findByName(name));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.info("Buscando usuário pelo email {}", email);
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public Optional<User> findById(Long id) {
        log.info("Buscando usuário pelo ID {}", id);
        return Optional.ofNullable(this.userRepository.getOne(id));
    }

}
