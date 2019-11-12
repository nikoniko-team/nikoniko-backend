package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.MemberDto;
import br.com.senac.nikoniko.entities.Team;
import br.com.senac.nikoniko.entities.TeamUser;
import br.com.senac.nikoniko.factories.MemberDtoFactory;
import br.com.senac.nikoniko.repositories.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final ModelMapper modelMapper;
    private final TeamRepository teamRepository;

    public TeamServiceImpl(ModelMapper modelMapper, TeamRepository teamRepository) {
        this.modelMapper = modelMapper;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<MemberDto> findAllUsersByTeamIdAndCurrentWeek(Long id) {
        var startOfWeek = OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.MONDAY).minusDays(1), ZoneOffset.UTC);
        var endOfWeek = OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.SATURDAY), ZoneOffset.UTC);
        var team = teamRepository.findFirstByIdAndCurrentWeek(id, startOfWeek, endOfWeek).orElseGet(Team::new);
        var userList = team.getTeamUserList() == null ? new ArrayList<TeamUser>() : team.getTeamUserList();

        return userList.stream()
            .map(MemberDtoFactory::create)
            .collect(Collectors.toList());
    }
}
