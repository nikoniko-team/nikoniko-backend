package br.com.senac.nikoniko.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class RecordDto {

    private MoodDto mood;
    private LocalDate date;

}
