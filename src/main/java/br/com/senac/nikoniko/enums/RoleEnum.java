package br.com.senac.nikoniko.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_ADMIN("ADMIN"),
    ROLE_MANAGER("MANAGER"),
    ROLE_USER("USER");

    private final String label;

    RoleEnum(String label) {
        this.label = label;
    }

}
