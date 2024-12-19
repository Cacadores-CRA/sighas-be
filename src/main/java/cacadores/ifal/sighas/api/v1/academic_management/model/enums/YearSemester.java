package cacadores.ifal.sighas.api.v1.academic_management.model.enums;

import lombok.Getter;

@Getter
public enum YearSemester {
    FIRST_SEMESTER(1), SECOND_SEMESTER(2);

    private final int semester;

    private YearSemester(int semester) {
        this.semester = semester;
    }
}
