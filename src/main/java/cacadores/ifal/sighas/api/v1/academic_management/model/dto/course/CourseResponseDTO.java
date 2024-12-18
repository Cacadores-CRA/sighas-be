package cacadores.ifal.sighas.api.v1.academic_management.model.dto.course;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.CourseType;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to represent courses in responses")
public record CourseResponseDTO(
        String code,
        String title,
        String shortTitle,
        CourseType type,
        Integer quantityOfSemesters
) {}
