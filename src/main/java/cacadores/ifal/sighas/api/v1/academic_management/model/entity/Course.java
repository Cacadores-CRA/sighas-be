package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.CourseType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tab_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;
    private String title;
    private String shortTitle;

    @Enumerated(EnumType.STRING)
    private CourseType type;

    private Integer quantityOfSemesters;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tab_course_has_subject")
    private Set<Subject> subjects;

    public Course(String code, String title, String shortTitle, CourseType type, Integer quantityOfSemesters) {
        this.code = code;
        this.title = title;
        this.shortTitle = shortTitle;
        this.type = type;
        this.quantityOfSemesters = quantityOfSemesters;
    }
}
