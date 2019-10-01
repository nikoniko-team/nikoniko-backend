package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Mood;
import br.com.senac.nikoniko.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    User findByName(String name);

    @Transactional(readOnly = true)
    User findByEmail(String email);

}
