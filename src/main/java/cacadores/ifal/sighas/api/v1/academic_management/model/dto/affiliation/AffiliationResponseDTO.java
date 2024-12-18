package cacadores.ifal.sighas.api.v1.academic_management.model.dto.affiliation;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.ConcreteAffiliationResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

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
