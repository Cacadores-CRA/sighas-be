package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.interfaces.Reservation;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.WeekDay;
import cacadores.ifal.sighas.api.v1.space_management.model.entity.Classroom;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class LessonReservation implements Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private WeekDay day;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private Classroom classroom;
}
