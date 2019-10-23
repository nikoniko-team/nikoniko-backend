package br.com.senac.nikoniko.dtos.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
