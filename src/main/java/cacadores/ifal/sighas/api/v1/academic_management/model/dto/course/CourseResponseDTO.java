package cacadores.ifal.sighas.api.v1.academic_management.model.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO used to represent courses in responses")
public record CourseResponseDTO(
        String code,
        String title,
        String shortName,
        Integer quantityOfSemesters
) {}
