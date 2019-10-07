package br.com.senac.nikoniko.dtos;


import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class MoodDto {

    private Long id;

    private String name;

    private String url;

}
