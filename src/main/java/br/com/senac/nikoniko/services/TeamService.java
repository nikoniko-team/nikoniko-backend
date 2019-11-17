package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.MemberDto;

import java.util.List;

public interface TeamService {

    List<MemberDto> findAllUsersByTeamIdAndCurrentWeek(Long id);

}
