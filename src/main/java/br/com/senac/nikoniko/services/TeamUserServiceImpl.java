package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.entities.TeamUser;
import br.com.senac.nikoniko.repositories.TeamUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamUserServiceImpl implements TeamUserService {

    private TeamUserRepository teamUserRepository;

    public TeamUserServiceImpl(TeamUserRepository teamUserRepository) {
        this.teamUserRepository = teamUserRepository;
    }

    @Override
    public Optional<TeamUser> findByTeamIdAndUserId(Long teamId, Long userId) {
        return teamUserRepository.findFirstByTeamIdAndUserId(teamId, userId);
    }

}
