package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(
    name = "tab_student",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "un_enrollment_tab_student",
            columnNames = {"enrollment"}
        )
    }
)
public class Student extends Affiliation {

    @Column(name = "enrollment", nullable = false)
    private String enrollment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    private Set<Group> groups;

    public Student(User user, LocalDate startingDate, LocalDate endingDate, AffiliationStatus status,
                   String enrollment) {
        this.setUser(user);
        this.setStartingDate(startingDate);
        this.setEndingDate(endingDate);
        this.setStatus(status);

        this.enrollment = enrollment;
    }
}
