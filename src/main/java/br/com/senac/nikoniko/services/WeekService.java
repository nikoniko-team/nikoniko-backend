package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.WeekDto;

public interface WeekService {

    WeekDto findByTeamId(Long id);

}
