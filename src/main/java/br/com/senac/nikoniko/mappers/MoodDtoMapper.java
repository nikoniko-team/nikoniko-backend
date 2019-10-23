package br.com.senac.nikoniko.mappers;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.entities.Mood;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MoodDtoMapper {

    public MoodDto convertToDto(Mood entity) {
        if (entity == null) {
            return MoodDto.builder().build();
        } else {
            return MoodDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .url("https://nikoniko-team.github.io/nikoniko-backend/assets/" + entity.getUrl())
                .build();
        }
    }

}
