package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import cacadores.ifal.sighas.api.v1.space_management.interfaces.Space;
import cacadores.ifal.sighas.api.v1.space_management.model.enums.BuildingType;

public class Building implements Space {
    private Long id;
    private String code;
    private BuildingType building;
}
