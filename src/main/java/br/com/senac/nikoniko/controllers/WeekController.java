package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.MemberDto;
import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.dtos.RecordDto;
import br.com.senac.nikoniko.dtos.WeekDto;
import br.com.senac.nikoniko.response.Response;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
@Api(value = "Api para CRUD de semanas")
@RequestMapping("/week")
@CrossOrigin(origins = "*")
public class WeekController {

    @GetMapping
    public ResponseEntity<Response<WeekDto>> find() {
        var response = new Response();

        var recordsFulaninho =
            Arrays.asList(
                RecordDto.builder()
                    .mood(MoodDto.builder()
                        .id(1L)
                        .name("Felizão")
                        .url("urlfelizao")
                        .build())
                    .date(LocalDate.of(2019, 9, 25))
                    .build(),
                RecordDto.builder()
                    .mood(MoodDto.builder()
                        .id(1L)
                        .name("Felizão")
                        .url("urlfelizao")
                        .build())
                    .date(LocalDate.of(2019, 9, 26))
                    .build()
            );

        var recordsMaluco =
            Arrays.asList(
                RecordDto.builder()
                    .mood(MoodDto.builder()
                        .id(5L)
                        .name("Triste")
                        .url("urltriste")
                        .build())
                    .date(LocalDate.of(2019, 9, 25))
                    .build(),
                RecordDto.builder()
                    .mood(MoodDto.builder()
                        .id(1L)
                        .name("Felizão")
                        .url("urlfelizao")
                        .build())
                    .date(LocalDate.of(2019, 9, 26))
                    .build()
            );

        var members =
            Arrays.asList(
                MemberDto.builder()
                    .id(1L)
                    .name("Fulaninho")
                    .records(recordsFulaninho)
                    .build(),
                MemberDto.builder()
                    .id(2L)
                    .name("Maluco")
                    .records(recordsMaluco)
                    .build()
            );

        var weekDto =
            WeekDto.builder()
                .members(members)
                .build();

        response.setData(weekDto);

        return ResponseEntity.ok(response);
    }

}
