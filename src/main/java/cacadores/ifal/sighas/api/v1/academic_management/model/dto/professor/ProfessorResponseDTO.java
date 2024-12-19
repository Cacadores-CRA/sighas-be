package cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.ConcreteAffiliationResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO used to represent professors in responses")
public record ProfessorResponseDTO(
    String siape,
    String name,
    String surname,
    AffiliationStatus status,
    EducationLevel education,
    String institutionalEmail,
    LocalDateTime createdAt
) implements ConcreteAffiliationResponseDTO {}
