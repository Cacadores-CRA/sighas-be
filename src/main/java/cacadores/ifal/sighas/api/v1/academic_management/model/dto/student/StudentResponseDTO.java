package cacadores.ifal.sighas.api.v1.academic_management.model.dto.student;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO used to represent students in responses")
public record StudentResponseDTO(
    String name,
    AffiliationStatus status,
    String enrollment,
    String institutionalEmail,
    LocalDateTime createdAt
) {}
