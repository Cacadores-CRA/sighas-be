package cacadores.ifal.sighas.api.v1.academic_management.model.dto.group;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Subject;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.GroupStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to represent groups in responses")
public record GroupResponseDTO(
        String code,
        Subject subject,
        GroupStatus status
) {}
