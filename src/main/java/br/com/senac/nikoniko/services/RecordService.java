package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.InRecordDto;
import br.com.senac.nikoniko.entities.TeamUser;

public interface RecordService {

    void save(InRecordDto inRecordDto, TeamUser teamUser);

}
