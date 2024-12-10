package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import cacadores.ifal.sighas.api.v1.space_management.interfaces.Laboratory;
import cacadores.ifal.sighas.api.v1.space_management.model.enums.AcademicRoomStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tab_computer_laboratory")
public class ComputerLaboratory extends InternalRoom implements Laboratory {
    private String code;
    private AcademicRoomStatus status;
}
