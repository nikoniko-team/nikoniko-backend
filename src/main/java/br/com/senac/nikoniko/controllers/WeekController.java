package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.WeekDto;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.WeekService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Api para CRUD de semanas")
@RequestMapping("/week")
@CrossOrigin(origins = "*")
public class WeekController {

    private final WeekService weekService;

    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }

    @GetMapping("/{teamId}/")
    @ApiOperation("Busca os registros da semana de um time")
    public ResponseEntity<Response<WeekDto>> find(@PathVariable("teamId") Long id) {
        var response = new Response<WeekDto>();

        response.setData(weekService.findByTeamId(id));

        return ResponseEntity.ok(response);
    }

}
