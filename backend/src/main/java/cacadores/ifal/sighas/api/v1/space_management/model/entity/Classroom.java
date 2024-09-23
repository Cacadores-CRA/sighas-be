package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import cacadores.ifal.sighas.api.v1.space_management.model.enums.AcademicRoomStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tab_classroom")
public class Classroom extends InternalRoom {
    private String code;
    private AcademicRoomStatus status;
}
