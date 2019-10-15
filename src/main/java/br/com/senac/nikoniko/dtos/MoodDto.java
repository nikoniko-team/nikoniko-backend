package br.com.senac.nikoniko.dtos;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MoodDto {

    private Long id;

    private String name;

    private String url;

}
