package br.com.senac.nikoniko.factories;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.entities.Mood;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MoodDtoFactory {

    public MoodDto convertToDto(Mood entity, String imagesUrl) {
        if (entity == null) {
            return MoodDto.builder().build();
        } else {
            return MoodDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .url(imagesUrl.concat(entity.getUrl()))
                .build();
        }
    }

}
