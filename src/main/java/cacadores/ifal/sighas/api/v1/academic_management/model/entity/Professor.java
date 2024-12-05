package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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
    name = "tab_professor",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "un_institutional_email_tab_professor",
            columnNames = {"institutional_email"}
        )
    }
)
public class Professor extends PublicServant {

    @Column(name = "institutional_email", nullable = false)
    private String institutionalEmail;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Group> groups;

    public Professor(User user, LocalDate startingDate, LocalDate endingDate, AffiliationStatus status,
                     String siape, EducationLevel education, Department department,
                     String institutionalEmail) {
        this.setUser(user);
        this.setStartingDate(startingDate);
        this.setEndingDate(endingDate);
        this.setStatus(status);

        this.setSiape(siape);
        this.setEducation(education);
        this.setDepartment(department);

        this.institutionalEmail = institutionalEmail;
    }
}
