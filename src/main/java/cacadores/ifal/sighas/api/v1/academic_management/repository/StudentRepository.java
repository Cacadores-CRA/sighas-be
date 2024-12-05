package cacadores.ifal.sighas.api.v1.academic_management.repository;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
