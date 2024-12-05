package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AffiliationStatus;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "tab_administrative_public_servant")
public class AdministrativePublicServant extends PublicServant {
    public AdministrativePublicServant(User user, LocalDate startingDate, LocalDate endingDate, AffiliationStatus status,
                                       String siape, EducationLevel education, Department department) {
        this.setUser(user);
        this.setStartingDate(startingDate);
        this.setEndingDate(endingDate);
        this.setStatus(status);

        this.setSiape(siape);
        this.setEducation(education);
        this.setDepartment(department);
    }
}
