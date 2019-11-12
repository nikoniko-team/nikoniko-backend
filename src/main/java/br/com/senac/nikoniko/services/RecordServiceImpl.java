package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.InRecordDto;
import br.com.senac.nikoniko.entities.Record;
import br.com.senac.nikoniko.entities.TeamUser;
import br.com.senac.nikoniko.repositories.RecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    private final ModelMapper modelMapper;
    private final RecordRepository recordRepository;

    public RecordServiceImpl(ModelMapper modelMapper, RecordRepository recordRepository) {
        this.modelMapper = modelMapper;
        this.recordRepository = recordRepository;
    }

    @Override
    public void save(InRecordDto inRecordDto, TeamUser teamUser) {
        var record = modelMapper.typeMap(InRecordDto.class, Record.class)
            .addMapping(InRecordDto::getTags, Record::setTags)
            .map(inRecordDto);

        record.setTeamUser(teamUser);

        recordRepository.save(record);
    }

}
