package cacadores.ifal.sighas.api.v1.app_management.model.dto.user;

import java.util.HashSet;
import java.util.UUID;

import cacadores.ifal.sighas.api.v1.app_management.model.enums.UserRole;

public record UserResponseDTO(
    UUID id,
    String name,
    String surname,
    String email,
    HashSet<UserRole> roles

) {}
