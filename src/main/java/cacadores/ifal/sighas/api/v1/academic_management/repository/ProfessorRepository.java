package cacadores.ifal.sighas.api.v1.academic_management.repository;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    Optional<Professor> findByUserId(UUID id);
    Optional<Professor> findBySiape(String siape);
}
