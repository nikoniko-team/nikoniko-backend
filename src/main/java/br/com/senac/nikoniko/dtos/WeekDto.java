package br.com.senac.nikoniko.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class WeekDto {

    List<MemberDto> members;

}
