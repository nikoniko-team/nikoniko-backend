package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.UserDto;
import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.UserService;
import br.com.senac.nikoniko.utils.PasswordUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@Api(value = "Api para usuario")
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public UserController() {
    }

    /**
     * Atualiza os dados de um usuário.
     *
     * @param id
     * @param userDto
     * @param result
     * @return ResponseEntity<Response < UserDto>>
     * @throws NoSuchAlgorithmException
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response<UserDto>> save(@PathVariable("id") Long id,
                                                  @Valid @RequestBody UserDto userDto,
                                                  BindingResult result)
        throws NoSuchAlgorithmException {
        log.info("Atualizando usuário: {}", userDto.toString());
        Response<UserDto> response = new Response<UserDto>();

        Optional<User> user = this.userService.findById(id);
        if (!user.isPresent()) {
            result.addError(new ObjectError("user", "Usuário não encontrado."));
        }

        this.updateUserEntity(user.get(), userDto, result);

        if (result.hasErrors()) {
            log.error("Erro validando usuário: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        this.userService.save(user.get());
        response.setData(this.converterUserDto(user.get()));

        return ResponseEntity.ok(response);
    }

    /**
     * Atualiza os dados do usuário com base nos dados encontrados no DTO.
     *
     * @param user
     * @param userDto
     * @param result
     * @throws NoSuchAlgorithmException
     */
    private void updateUserEntity(User user, UserDto userDto, BindingResult result)
        throws NoSuchAlgorithmException {
        user.setName(userDto.getName());

        if (!user.getEmail().equals(userDto.getEmail())) {
            this.userService.findByEmail(userDto.getEmail())
                .ifPresent(func -> result.addError(
                    new ObjectError("email", "Email já existente.")));
            user.setEmail(userDto.getEmail());
        }

        if (userDto.getPassword() != null && !userDto.getPassword().trim().isEmpty()) {
            user.setPassword(PasswordUtils.generateBCrypt(userDto.getPassword()));
        }

        if (userDto.getRole() != null) {
            user.setRole(userDto.getRole());
        }

    }

    /**
     * Retorna um DTO com os dados de um usuário.
     *
     * @param user
     * @return UserDto
     */
    private UserDto converterUserDto(User user) {
        return UserDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            //.password(Optional.of(user.getPassword()))
            .role(user.getRole())
            .build();
    }

}
