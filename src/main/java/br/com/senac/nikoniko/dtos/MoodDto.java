package br.com.senac.nikoniko.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoodDto {

    private Long id;

    private String name;

    private String url;

}
