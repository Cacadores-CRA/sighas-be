package cacadores.ifal.sighas.api.v1.academic_management.repository;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
