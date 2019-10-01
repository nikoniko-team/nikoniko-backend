package br.com.senac.nikoniko.services;


import br.com.senac.nikoniko.entities.User;

import java.util.Optional;

public interface UserService {

    /**
     * Persiste um usuário na base de dados.
     *
     * @param user
     * @return User
     */
    User save(User user);

    /**
     * Busca e retorna um usuário por um nome.
     *
     * @param name
     * @return Optional<User>
     */
    Optional<User> findByName(String name);

    /**
     * Busca e retorna um usuário por um email.
     *
     * @param email
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);

    /**
     * Busca e retorna um usuário por ID.
     *
     * @param id
     * @return Optional<User>
     */
    Optional<User> findById(Long id);

}
