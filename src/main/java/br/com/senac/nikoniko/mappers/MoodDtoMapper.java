package br.com.senac.nikoniko.mappers;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.entities.Mood;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MoodDtoMapper {

    public MoodDto convertToDto(Mood entity) {
        return MoodDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .url(entity.getUrl())
            .build();
    }

}
