package cacadores.ifal.sighas.api.v1.academic_management.model.dto.group;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.professor.ProfessorResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.student.StudentResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.GroupStatus;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Schema(description = "DTO used to represent groups in responses")
public record GroupResponseDTO(
        UUID id,
        String code,
        UUID subjectId,
        String academicPeriod,
        GroupStatus status,
        Set<ProfessorResponseDTO> professors,
        Set<StudentResponseDTO> students,
        LocalDateTime createdAt
) {}
