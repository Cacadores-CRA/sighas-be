package cacadores.ifal.sighas.api.v1.academic_management.model.dto.affiliation;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.ConcreteAffiliationResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO used to represent affiliations in responses")
public record AffiliationResponseDTO(
        UUID id,
        UUID userId,
        LocalDate startingDate,
        LocalDate endingDate,
        String affiliationType,
        AffiliationStatus status,
        ConcreteAffiliationResponseDTO affiliationDetails,
        LocalDateTime createdAt
) {}
