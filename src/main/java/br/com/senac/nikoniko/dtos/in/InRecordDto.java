package br.com.senac.nikoniko.dtos.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class InRecordDto {

    @JsonProperty("mood_id")
    private Long moodId;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("tags")
    private List<TagDto> tags;

    @JsonProperty("comment")
    private String comment;

}
