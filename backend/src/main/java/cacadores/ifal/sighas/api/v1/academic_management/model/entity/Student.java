package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tab_student")
public class Student extends Affiliation {
    @Id
    private String enrollment;

    private Course course;
    private Set<Group> groups;
}
