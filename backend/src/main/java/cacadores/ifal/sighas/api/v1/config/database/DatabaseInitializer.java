package cacadores.ifal.sighas.api.v1.config.database;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;
import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AppRole;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRoleRepository;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    private final UserRoleRepository userRoleRepository;
    public DatabaseInitializer(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertAppRoles() {
        userRoleRepository.save(new UserRole(AppRole.ADMIN));
        userRoleRepository.save(new UserRole(AppRole.USER));
    }
}
