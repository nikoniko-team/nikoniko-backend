package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.InRecordDto;

public interface RecordService {

    void save(InRecordDto inRecordDto, Long teamId, Long userId);

}
