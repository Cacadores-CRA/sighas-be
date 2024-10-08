package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.EducationLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(
    name = "tab_public_servant",
    uniqueConstraints = @UniqueConstraint(
        name = "un_siape_tab_public_servant",
        columnNames = {"siape"}
    )
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PublicServant extends Affiliation {

    @Column(name = "siape", nullable = false)
    private String siape;

    @Column(name = "education_level", nullable = false)
    private EducationLevel education;

    @ManyToOne
    @JoinColumn(name = "dapartment_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "tab_public_servant_has_role")
    private Set<PublicServantRole> roles = new HashSet<>();
}
