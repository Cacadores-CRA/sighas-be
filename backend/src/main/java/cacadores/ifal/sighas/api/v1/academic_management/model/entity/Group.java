package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.GroupStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tab_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToMany
    @JoinTable(name = "tab_group_has_professor")
    private Set<Professor> professors;

    @ManyToMany
    @JoinTable(name = "tab_group_has_student")
    private Set<Student> students;

    @OneToMany(mappedBy = "group")
    private Set<AcademicLessonReservation> schedules;
    private GroupStatus status;

    public Group(String code, Subject subject, GroupStatus status) {
        this.code = code;
        this.subject = subject;
        this.status = status;
    }
}
