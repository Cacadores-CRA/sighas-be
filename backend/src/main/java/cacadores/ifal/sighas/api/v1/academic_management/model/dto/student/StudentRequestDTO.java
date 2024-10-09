package cacadores.ifal.sighas.api.v1.academic_management.model.dto.student;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Course;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Group;


import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.Set;

@Schema(description = "DTO used to represent students in responses")
public record StudentRequestDTO(
        @NotBlank(message = "Enrollement student is obligatory")
        String enrollment,
        @Email(message = "Invalid email address")
        String institutionalEmail
) {}

