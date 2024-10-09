package cacadores.ifal.sighas.api.v1.academic_management.database;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.Department;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AppRole;
import cacadores.ifal.sighas.api.v1.academic_management.repository.DepartmentRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRoleRepository;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
//TODO: Implement exception treatment when spring.jpa.hibernate.ddl-auto is updated
public class DatabaseInitializer {
    private final UserRoleRepository userRoleRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    public DatabaseInitializer(UserRoleRepository userRoleRepository, DepartmentRepository departmentRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        insertUserRoles();
        insertDefaultDepartments();
        insertDefaultUsers();
    }

    private void insertUserRoles() {
        userRoleRepository.save(new UserRole(AppRole.ADMIN));
        userRoleRepository.save(new UserRole(AppRole.USER));
    }

    private void insertDefaultDepartments() {
        departmentRepository.save(new Department("001", "INFORMATION SYSTEM BACHELOR DEPARTMENT"));
        departmentRepository.save(new Department("002", "MATH DEPARTMENT"));
        departmentRepository.save(new Department("003", "DAA DEPARTMENT"));
    }

    private void insertDefaultUsers() {
        UserRole ROLE_ADMIN = userRoleRepository.findById(0).orElseThrow(
                () -> new RuntimeException("Invalid role assignment")
        );
        UserRole ROLE_USER = userRoleRepository.findById(1).orElseThrow(
                () -> new RuntimeException("Invalid role assignment")
        );

        userRepository.save(
            new User(
                "12312312345",
                "Ivo",
                "Calado",
                LocalDate.of(1980, 01, 01),
                "ivinho.darkside@gmail.com",
                "ivinho123",
                new HashSet<>(Set.of(ROLE_ADMIN))
            )
        );

        userRepository.save(
            new User(
                "32132132132",
                "Ricardo",
                "Rúbens",
                LocalDate.of(1980, 12, 12),
                "ricardinho.ciclope@gmail.com",
                "ricardinho123",
                new HashSet<>(Set.of(ROLE_USER))
            )
        );
    }
}