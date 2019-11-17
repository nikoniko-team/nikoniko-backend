package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.WeekDto;
import org.springframework.stereotype.Service;

@Service
public class WeekServiceImpl implements WeekService {

    private final TeamService teamService;

    public WeekServiceImpl(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public WeekDto findByTeamId(Long id) {
        return WeekDto.builder()
            .members(teamService.findAllUsersByTeamIdAndCurrentWeek(id))
            .build();
    }
}
