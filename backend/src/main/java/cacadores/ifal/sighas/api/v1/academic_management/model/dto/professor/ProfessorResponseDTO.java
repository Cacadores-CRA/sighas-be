package cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to represent professors in responses")
public record ProfessorResponseDTO(
    //TODO: Confirm if any extra field is necessary
    String siape,
    String name,
    AffiliationStatus status,
    EducationLevel education,
    String institutionalEmail
) {}
