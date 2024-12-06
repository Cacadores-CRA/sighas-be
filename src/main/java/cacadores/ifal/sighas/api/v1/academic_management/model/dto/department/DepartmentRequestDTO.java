package cacadores.ifal.sighas.api.v1.academic_management.model.dto.department;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO for creating and updating departments")
public record DepartmentRequestDTO(
    @NotBlank(message = "Invalid department code")
    String code,

    @NotBlank(message = "Invalid department name")
    String name
) {}
