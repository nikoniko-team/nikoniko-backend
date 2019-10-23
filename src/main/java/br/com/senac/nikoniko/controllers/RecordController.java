package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.in.InRecordDto;
import br.com.senac.nikoniko.response.Response;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Api para CRUD de registros do time")
@RequestMapping("/record")
@CrossOrigin(origins = "*")
public class RecordController {

    @PostMapping("/{teamId}/{userId}/")
    @ApiOperation("Insere um registro de humor")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Registro de humor criado", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity save(@ApiParam("ID do time que terá o registro") @PathVariable("teamId") Long teamId,
                               @ApiParam("ID do usuário que terá o registro") @PathVariable("userId") Long userId,
                               @ApiParam("Objeto de registro a ser salvo") @RequestBody InRecordDto inRecordDto)  {
        return ResponseEntity.noContent().build();

    }

}
