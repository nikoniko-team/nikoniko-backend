package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.entities.Mood;
import br.com.senac.nikoniko.exception.InexistentMoodException;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.MoodService;
import br.com.senac.nikoniko.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Api para CRUD de humor")
@RequestMapping("/mood")
@CrossOrigin(origins = "*")
public class MoodController {

    @Autowired
    private MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/{moodId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<Response<MoodDto>> findById(@PathVariable(value = "moodId") Long id) throws InexistentMoodException {
        Response<MoodDto> response = new Response<>();
        Optional<Mood> mood = moodService.findById(id);
        response.setData(this.convertToDto(mood.get()));
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<Response<List<MoodDto>>> findAll() {
        Response<List<MoodDto>> response = new Response<>();
        List<Mood> moods = moodService.findAll();
        response.setData(new ArrayList<>());
        for (Mood entity : moods) {
            response.getData().add(this.convertToDto(entity));
        }
        return ResponseEntity.ok(response);
    }

    private MoodDto convertToDto(Mood entity) {
        return MoodDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .url(entity.getUrl())
            .build();
    }

    private Mood convertToEntity(MoodDto dto) {
        Mood entity = new Mood();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        return entity;
    }

}
