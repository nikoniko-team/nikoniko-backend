package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {

    Optional<TeamUser> findFirstByTeamIdAndUserId(Long teamId, Long userId);

}
