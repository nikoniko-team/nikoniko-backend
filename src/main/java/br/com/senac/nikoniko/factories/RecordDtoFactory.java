package br.com.senac.nikoniko.factories;

import br.com.senac.nikoniko.dtos.RecordDto;
import br.com.senac.nikoniko.entities.Record;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class RecordDtoFactory {

    public RecordDto create(Record record) {
        return new ModelMapper().createTypeMap(Record.class, RecordDto.class)
            .addMapping(Record::getLocalDate, RecordDto::setDate)
            .map(record);
    }

}
