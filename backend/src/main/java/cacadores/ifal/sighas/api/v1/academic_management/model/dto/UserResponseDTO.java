package cacadores.ifal.sighas.api.v1.academic_management.model.dto;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String cpf,
        String name,
        String surname,
        LocalDate birthdate,
        String email,
        Set<UserRole> roles
) {
}
