package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.AdministrativePublicServant;
import cacadores.ifal.sighas.api.v1.academic_management.repository.AdministrativePublicServantRepository;

import org.springframework.stereotype.Service;

@Service
public class AdministrativePublicServantService {
    private final AdministrativePublicServantRepository repository;
    public AdministrativePublicServantService(AdministrativePublicServantRepository administrativePublicServantRepository) {
        this.repository = administrativePublicServantRepository;
    }

    public AdministrativePublicServant createAdministrativePublicServant(AdministrativePublicServant administrative) {
        return repository.save(administrative);
    }
}
