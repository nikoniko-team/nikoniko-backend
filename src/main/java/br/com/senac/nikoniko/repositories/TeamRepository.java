package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t " +
        "FROM Team t " +
        "JOIN t.teamUserList tu " +
        "JOIN tu.recordList r " +
        "WHERE t.id = :id")
    Optional<Team> findFirstById(Long id);

}
