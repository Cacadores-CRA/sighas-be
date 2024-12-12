package cacadores.ifal.sighas.api.v1.academic_management.model.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO for creating and updating courses")
public record CourseRequestDTO(
    @NotBlank(message = "Invalid course code")
    String code,

    @NotBlank(message = "Invalid course name")
    String title,

    @NotBlank(message = "Invalid course code")
    String shortName,

    @NotBlank(message = "Invalid course name")
    Integer quantityOfSemesters
) {}
