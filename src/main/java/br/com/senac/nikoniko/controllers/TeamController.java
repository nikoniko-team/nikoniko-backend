package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.TeamDto;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.TeamUserService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Api para CRUD de registros do time")
@RequestMapping("/team")
@CrossOrigin(origins = "*")
public class TeamController {

    private final TeamUserService teamUserService;

    public TeamController(TeamUserService teamUserService) {
        this.teamUserService = teamUserService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{userId}")
    @ApiOperation("Busca todos os times que um usuário participa")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Time localizado", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity<Response<List<TeamDto>>> findAllByUserId(@ApiParam(value = "ID do usuário", required = true)
                                              @PathVariable("userId") Long userId) {
        var response = new Response<List<TeamDto>>();

        response.setData(teamUserService.findTeamsByUserId(userId));

        return ResponseEntity.ok(response);
    }

}
