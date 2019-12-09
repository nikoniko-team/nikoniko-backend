package br.com.senac.nikoniko.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntryDto {

    private String name;
    private Long value;

}
