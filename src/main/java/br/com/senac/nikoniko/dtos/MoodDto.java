package br.com.senac.nikoniko.dtos;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Wither;

@Builder
@Data
@Getter
@Setter
@Wither
public class MoodDto {

    private Long id;

    private String name;

    private String url;

}
