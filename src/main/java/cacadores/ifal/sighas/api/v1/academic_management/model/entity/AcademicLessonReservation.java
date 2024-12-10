package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.Reservation;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.WeekDay;
import cacadores.ifal.sighas.api.v1.space_management.model.entity.Classroom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tab_lesson_reservation")
public class AcademicLessonReservation implements Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private WeekDay day;
    private LocalTime startingTime;
    //TODO: Establish business logic to boundary hours
    private LocalTime endingTime;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinTable(name = "group_id")
    private Group group;

    public AcademicLessonReservation(WeekDay day, LocalTime startingTime, LocalTime endingTime, Classroom classroom, Group group) {
        this.day = day;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.classroom = classroom;
        this.group = group;
    }
}
