package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.administrative_public_servant.AdministrativePublicServantResponseDTO;
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

    //ENTITY TO RESPONSE DTO
    protected AdministrativePublicServantResponseDTO toAdministrativePublicServantResponseDTO(AdministrativePublicServant administrativePublicServant) {
        return new AdministrativePublicServantResponseDTO(
                administrativePublicServant.getUser().getName()
        );
    }
}
