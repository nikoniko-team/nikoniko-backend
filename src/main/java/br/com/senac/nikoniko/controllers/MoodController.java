package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.exception.InexistentMoodException;
import br.com.senac.nikoniko.mappers.MoodDtoMapper;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.MoodService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "Api para CRUD de humor")
@RequestMapping("/mood")
@CrossOrigin(origins = "*")
public class MoodController {

    private MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/{moodId}")
    public ResponseEntity<Response<MoodDto>> findById(@PathVariable(value = "moodId") Long id) throws InexistentMoodException {
        Response<MoodDto> response = new Response<>();

        moodService.findById(id)
            .ifPresent(mood -> response.setData(MoodDtoMapper.convertToDto(mood)));

        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<Response<List<MoodDto>>> findAll() {
        Response<List<MoodDto>> response = new Response<>();

        response.setData(
            moodService.findAll().stream()
                .map(MoodDtoMapper::convertToDto)
                .collect(Collectors.toList())
        );

        return ResponseEntity.ok(response);
    }

}
