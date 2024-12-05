package cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "DTO used to represent professors in responses")
public record ProfessorRequestDTO(
        @NotNull(message = "User ID is obligatory")
        UUID userId,
        @NotNull(message = "Staring date is obligatory")
        LocalDate startingDate,
        LocalDate endingDate,
        @NotNull(message = "Invalid status")
        AffiliationStatus status,
        @NotBlank(message = "Siape field is obligatory")
        //TODO: Implement RegExr
        String siape,
        @NotNull(message = "Invalid education level")
        EducationLevel education,
        @NotNull(message = "Department ID is obligatory")
        UUID departmentId,
        @Email(message = "Invalid email address")
        //TODO: Implement RegExr
        String institutionalEmail
) {}
