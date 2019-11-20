package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.exception.InexistentMoodException;
import br.com.senac.nikoniko.factories.MoodDtoFactory;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.MoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${assets.images.url}")
    private String imagesUrl;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/{moodId}")
    @ApiOperation("Busca o humor por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Humor localizado", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity<Response<MoodDto>> findById(@PathVariable(value = "moodId") Long id) throws InexistentMoodException {
        Response<MoodDto> response = new Response<>();

        moodService.findById(id)
            .ifPresent(mood -> response.setData(MoodDtoFactory.convertToDto(mood, imagesUrl)));

        return ResponseEntity.ok(response);

    }

    @GetMapping
    @ApiOperation("Busca todos os humores")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Humores localizados", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity<Response<List<MoodDto>>> findAll() {
        Response<List<MoodDto>> response = new Response<>();

        response.setData(
            moodService.findAll().stream()
                .map(entity -> MoodDtoFactory.convertToDto(entity, imagesUrl))
                .collect(Collectors.toList())
        );

        return ResponseEntity.ok(response);
    }

}
