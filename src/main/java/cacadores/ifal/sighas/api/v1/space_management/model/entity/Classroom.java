package cacadores.ifal.sighas.api.v1.space_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.AcademicLessonReservation;
import cacadores.ifal.sighas.api.v1.space_management.model.enums.AcademicRoomStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tab_classroom")
public class Classroom extends InternalRoom {
    private String code;
    private AcademicRoomStatus status;

    @OneToMany(mappedBy = "classroom")
    Set<AcademicLessonReservation> academicLessonReservations = new HashSet<>();

    public Classroom(Building building, String code, AcademicRoomStatus status) {
        this.setBuilding(building);

        this.code = code;
        this.status = status;
    }
}
