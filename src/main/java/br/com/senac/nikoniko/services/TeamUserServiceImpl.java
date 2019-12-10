package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.TeamDto;
import br.com.senac.nikoniko.entities.TeamUser;
import br.com.senac.nikoniko.repositories.TeamUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamUserServiceImpl implements TeamUserService {

    private TeamUserRepository teamUserRepository;
    private ModelMapper modelMapper;


    public TeamUserServiceImpl(TeamUserRepository teamUserRepository, ModelMapper modelMapper) {
        this.teamUserRepository = teamUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<TeamUser> findByTeamIdAndUserId(Long teamId, Long userId) {
        return teamUserRepository.findFirstByTeamIdAndUserId(teamId, userId);
    }

    @Override
    public List<TeamDto> findTeamsByUserId(Long userId) {
        return teamUserRepository.findAllByUserId(userId).stream()
            .map(teamUser -> modelMapper.map(teamUser.getTeam(), TeamDto.class))
            .collect(Collectors.toList());
    }

}
