package cacadores.ifal.sighas.api.v1.academic_management.model.dto.administrative_public_servant;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.ConcreteAffiliationResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to represent administrative public servants in responses")
public record AdministrativePublicServantResponseDTO(
        String name
) implements ConcreteAffiliationResponseDTO {}
