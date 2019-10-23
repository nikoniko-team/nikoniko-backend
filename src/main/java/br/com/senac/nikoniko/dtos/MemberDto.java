package br.com.senac.nikoniko.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class MemberDto {

    private Long id;
    private String name;
    private List<RecordDto> records;

}
