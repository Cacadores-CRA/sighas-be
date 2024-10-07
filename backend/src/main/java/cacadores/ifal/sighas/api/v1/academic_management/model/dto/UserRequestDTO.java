package cacadores.ifal.sighas.api.v1.academic_management.model.dto;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;

import java.time.LocalDate;
import java.util.Set;

public record UserRequestDTO(
    String cpf,
    String name,
    String surname,
    LocalDate birthdate,
    String email,
    String password,
    Set<UserRole> roles
) {

    public User toUser() {
        return new User(
            cpf(),
            name(),
            surname(),
            birthdate(),
            email(),
            password(),
            roles()
        );
    }
}
