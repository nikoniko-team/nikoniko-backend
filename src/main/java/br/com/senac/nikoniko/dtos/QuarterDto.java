package br.com.senac.nikoniko.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class QuarterDto {

    private String month;
    private Integer order;
    private List<EntryDto> entries;

}
