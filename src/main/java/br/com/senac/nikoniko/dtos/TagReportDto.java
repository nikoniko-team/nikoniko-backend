package br.com.senac.nikoniko.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TagReportDto {

    public TagReportDto(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("count")
    private Long count;

}
