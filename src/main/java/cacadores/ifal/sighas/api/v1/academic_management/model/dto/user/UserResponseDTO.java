package cacadores.ifal.sighas.api.v1.academic_management.model.dto.user;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AppRole;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Schema(description = "DTO used to represent users in responses")
public record UserResponseDTO(
        UUID id,
        String cpf,
        String name,
        String surname,
        //TODO: Convert date format
        LocalDate birthdate,
        String email,
        Set<AppRole> roles
) {}
