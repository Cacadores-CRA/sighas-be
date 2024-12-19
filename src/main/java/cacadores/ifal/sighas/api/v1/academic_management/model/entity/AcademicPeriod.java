package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.YearSemester;

import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class AcademicPeriod {
    private Year year;
    private YearSemester semester;

    public AcademicPeriod(Integer year, YearSemester semester) {
        this.year = Year.of(year);
        this.semester = semester;
    }

    @Override
    public String toString() {
        return year.toString() + "." + semester.getSemester();
    }
}
