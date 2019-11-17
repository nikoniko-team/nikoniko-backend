package br.com.senac.nikoniko.factories;

import br.com.senac.nikoniko.dtos.MemberDto;
import br.com.senac.nikoniko.entities.TeamUser;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class MemberDtoFactory {

    public MemberDto create(TeamUser teamUser) {
        return MemberDto.builder()
            .id(teamUser.getUserId())
            .name(teamUser.getUserName())
            .records(
                teamUser.getRecordList()
                    .stream()
                    .map(RecordDtoFactory::create)
                    .collect(Collectors.toList())
            )
            .build();
    }

}
