package br.com.senac.nikoniko.controller;

import br.com.senac.nikoniko.entity.Mood;
import br.com.senac.nikoniko.exception.InexistentMoodException;
import br.com.senac.nikoniko.service.MoodService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Api para CRUD de humor")
@RequestMapping(value = "mood")
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping(path = "{moodId}")
    public Mood find(
            @PathVariable(value = "moodId") Integer id
    ) throws InexistentMoodException {
        return moodService.find(id);
    }

    @GetMapping
    public List<Mood> findAll() {
        return moodService.findAll();
    }
}
