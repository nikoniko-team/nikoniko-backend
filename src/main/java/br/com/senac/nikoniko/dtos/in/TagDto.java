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

    @JsonProperty("tag_id")
    private Long tagId;

    @JsonProperty("name")
    private String name;

}
