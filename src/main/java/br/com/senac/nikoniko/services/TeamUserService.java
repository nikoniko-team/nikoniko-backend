package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.TeamDto;
import br.com.senac.nikoniko.entities.TeamUser;

import java.util.List;
import java.util.Optional;

public interface TeamUserService {

    Optional<TeamUser> findByTeamIdAndUserId(Long teamId, Long userId);

    List<TeamDto> findTeamsByUserId(Long userId);
}
