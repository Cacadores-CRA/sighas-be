package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import java.util.UUID;

import cacadores.ifal.sighas.api.v1.space_management.interfaces.Space;
import cacadores.ifal.sighas.api.v1.space_management.model.enums.RoomStatus;

public abstract class Room implements Space {
    private UUID id;
    private RoomStatus status;
    private String details;
}
