package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.in.InRecordDto;
import br.com.senac.nikoniko.exception.InexistentTeamUserException;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.RecordService;
import br.com.senac.nikoniko.services.TeamUserService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Api para CRUD de registros do time")
@RequestMapping("/record")
@CrossOrigin(origins = "*")
public class RecordController {

    private final RecordService recordService;
    private final TeamUserService teamUserService;

    public RecordController(RecordService recordService, TeamUserService teamUserService) {
        this.recordService = recordService;
        this.teamUserService = teamUserService;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/{teamId}/{userId}/")
    @ApiOperation("Insere um registro de humor")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Registro de humor criado", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity save(@ApiParam(value = "ID do time que terá o registro", required = true) @PathVariable("teamId") Long teamId,
                               @ApiParam(value = "ID do usuário que terá o registro", required = true) @PathVariable("userId") Long userId,
                               @ApiParam(value = "Objeto de registro a ser salvo", required = true) @RequestBody InRecordDto inRecordDto)  {
        recordService.save(inRecordDto,
            teamUserService.findByTeamIdAndUserId(teamId, userId)
                .orElseThrow(InexistentTeamUserException::new)
        );
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{teamId}")
    @ApiOperation("Busca todos os registro de humor de um time")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Registro de humor criado", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity findAllByTeam(@ApiParam(value = "ID do time para buscar os registros", required = true) @PathVariable("teamId") Long teamId)  {
        return ResponseEntity.noContent().build();

    }

}
