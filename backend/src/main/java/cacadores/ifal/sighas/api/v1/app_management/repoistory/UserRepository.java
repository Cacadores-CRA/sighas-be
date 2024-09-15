package cacadores.ifal.sighas.api.v1.app_management.repoistory;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cacadores.ifal.sighas.api.v1.app_management.model.entity.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findUserByEmail(String email);
    void deleteById(UUID id);
    void deleteByEmail(String email);

    Boolean existsUserById(UUID id);
    Boolean existsUserByEmail(String email);
}
