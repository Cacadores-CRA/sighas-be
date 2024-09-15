package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import java.util.UUID;

import cacadores.ifal.sighas.api.v1.space_management.interfaces.Laboratory;

public class ComputerLaboratory extends Room implements Laboratory {
    private UUID id;
    private String code;
    private Building building;
    
}
