package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.InRecordDto;
import br.com.senac.nikoniko.entities.Record;
import br.com.senac.nikoniko.entities.TeamUser;

import java.util.List;

public interface RecordService {

    void save(InRecordDto inRecordDto, TeamUser teamUser);

    List<Record> findCurrentWeekByTeamUser(Long id);
}
