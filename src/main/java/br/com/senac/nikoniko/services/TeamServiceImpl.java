package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.MemberDto;
import br.com.senac.nikoniko.entities.Team;
import br.com.senac.nikoniko.entities.TeamUser;
import br.com.senac.nikoniko.factories.MemberDtoFactory;
import br.com.senac.nikoniko.repositories.TeamRepository;
import br.com.senac.nikoniko.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<MemberDto> findAllUsersByTeamIdAndCurrentWeek(Long id) {
        var team = teamRepository.findFirstByIdAndCurrentWeek(id, DateUtils.getStartOfWeekAsString(), DateUtils.getEndOfWeekAsString())
            .orElseGet(Team::new);
        var userList = team.getTeamUserList() == null ? new ArrayList<TeamUser>() : team.getTeamUserList();

        return userList.stream()
            .map(MemberDtoFactory::create)
            .collect(Collectors.toList());
    }
}
