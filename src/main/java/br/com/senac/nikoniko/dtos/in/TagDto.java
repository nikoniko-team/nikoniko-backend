package br.com.senac.nikoniko.dtos.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class TagDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
