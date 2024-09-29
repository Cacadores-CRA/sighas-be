package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class CivilServant extends Affiliation {
    @Id
    private String siape;
    private EducationLevel education;
    private Department department;
}
