package br.com.senac.nikoniko.factories;

import br.com.senac.nikoniko.dtos.RecordDto;
import br.com.senac.nikoniko.entities.Record;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RecordDtoFactory {

    public RecordDto create(Record record, String imagesUrl) {
        return RecordDto.builder()
            .date(record.getLocalDate())
            .mood(MoodDtoFactory.convertToDto(record.getMood(), imagesUrl))
            .build();
    }

}
