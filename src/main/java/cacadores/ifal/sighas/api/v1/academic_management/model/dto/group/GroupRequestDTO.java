package cacadores.ifal.sighas.api.v1.academic_management.model.dto.group;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Subject;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.GroupStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO for creating and updating groups")
public record GroupRequestDTO(
        @NotBlank(message = "Invalid group code")
        String code,
        Subject subject,
        GroupStatus status
) {}
