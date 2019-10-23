package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.in.TagDto;
import br.com.senac.nikoniko.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Api para CRUD de tags")
@RequestMapping("/tag")
@CrossOrigin(origins = "*")
public class TagController {

    @GetMapping
    @ApiOperation("Busca todas as tags")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Tags localizadas", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity<Response<List<TagDto>>> findAll() {
        Response<List<TagDto>> response = new Response<>();

        return ResponseEntity.ok(response);
    }

    @ApiOperation("Busca a tag por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Tag localizada", response = void.class),
        @ApiResponse(code = 400, message = "Requisição inválida, valide os parâmetros de entrada", response = Response.class),
        @ApiResponse(code = 422, message = "Erro semântico na requisição, valide os parâmetros de entrada", response = Response.class),
    })
    public ResponseEntity<Response<TagDto>> findById(@PathVariable(value = "moodId") Long id) {
        Response<TagDto> response = new Response<>();

        return ResponseEntity.ok(response);

    }

}
