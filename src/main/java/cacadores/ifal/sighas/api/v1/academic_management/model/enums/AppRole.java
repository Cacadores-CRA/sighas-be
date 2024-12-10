package cacadores.ifal.sighas.api.v1.academic_management.model.enums;

import lombok.Getter;

@Getter
public enum AppRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    AppRole(String role) {
        this.role = role;
    }
}
