package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;

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
        ),
        @UniqueConstraint(
                name = "un_institutional_email_tab_student",
                columnNames = {"institutional_email"}
        )
    }
)
public class Student extends Affiliation {

    @Pattern(regexp = "^\\d{10}$", message = "The enrollment code must contain exactly 10 numeric digits")
    @Column(name = "enrollment", nullable = false)
    private String enrollment;

    @Column(name = "institutional_email", nullable = false)
    private String institutionalEmail;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Group> groups;

    public Student(User user, LocalDate startingDate, LocalDate endingDate, AffiliationStatus status,
                   String enrollment, String institutionalEmail) {
        this.setUser(user);
        this.setStartingDate(startingDate);
        this.setEndingDate(endingDate);
        this.setStatus(status);

        this.enrollment = enrollment;
        this.institutionalEmail = institutionalEmail;
    }
}
