package br.com.senac.nikoniko.security;

import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    /**
     * Converte e gera um JwtUser com base nos dados de um usuário.
     *
     * @param user
     * @return JwtUser
     */
    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
            mapToGrantedAuthorities(user.getRole()));
    }

    /**
     * Converte o perfil do usuário para o Spring Security.
     *
     * @param roleEnum
     * @return List<GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(RoleEnum roleEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(roleEnum.toString()));
        return authorities;
    }

}
