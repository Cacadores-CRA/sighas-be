package cacadores.ifal.sighas.api.v1.academic_management.model.dto.student;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Course;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Group;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(description = "DTO used to represent professors in responses")
public record StudentResponseDTO(
        String enrollment,
        String institutionalEmail,
        Course course,
        Set<Group> groups
) {}