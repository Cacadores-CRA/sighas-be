package cacadores.ifal.sighas.api.v1.academic_management.model.dto.administrative_public_servant;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.ConcreteAffiliationResponseDTO;

public record AdministrativePublicServantResponseDTO(
        String name
) implements ConcreteAffiliationResponseDTO {}
