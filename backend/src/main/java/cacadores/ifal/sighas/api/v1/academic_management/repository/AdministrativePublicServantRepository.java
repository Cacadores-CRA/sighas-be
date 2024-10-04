package cacadores.ifal.sighas.api.v1.academic_management.repository;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.AdministrativePublicServant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdministrativePublicServantRepository extends JpaRepository<AdministrativePublicServant, UUID> {

}
