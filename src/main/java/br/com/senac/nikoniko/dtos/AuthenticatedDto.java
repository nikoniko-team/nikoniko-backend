package br.com.senac.nikoniko.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticatedDto {

    private String email;
    private String token;

}
