package cacadores.ifal.sighas.api.v1.academic_management.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Department {
    @Id
    private UUID id;
    private String code;
    private String title;
}
