package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    User findByName(String name);

    @Transactional(readOnly = true)
    Optional<User> findByEmail(String email);

}
