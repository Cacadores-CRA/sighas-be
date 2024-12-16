package cacadores.ifal.sighas.api.v1.academic_management.model.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to represent groups in responses")
public record SubjectResponseDTO(
        String code,
        String title,
        String shortTitle
) {}
