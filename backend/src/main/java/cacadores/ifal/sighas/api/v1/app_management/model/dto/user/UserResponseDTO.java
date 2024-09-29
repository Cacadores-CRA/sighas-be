package cacadores.ifal.sighas.api.v1.app_management.model.dto.user;

import java.util.HashSet;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
    String name,
    String surname,
    String email,
    HashSet<UserRole> roles

) {}
