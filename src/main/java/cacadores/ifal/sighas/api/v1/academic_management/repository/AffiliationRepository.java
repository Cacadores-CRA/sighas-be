package cacadores.ifal.sighas.api.v1.academic_management.repository;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Affiliation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AffiliationRepository extends JpaRepository<Affiliation, UUID> {
    List<Affiliation> findAllByUserId(UUID userId);
}
