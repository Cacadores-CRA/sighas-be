package cacadores.ifal.sighas.api.v1.app_management.model.dto.user;

import java.util.HashSet;

import cacadores.ifal.sighas.api.v1.app_management.model.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Name field is mandatory") 
        String name,

        @NotBlank(message = "Surname field is mandatory") 
        String surname,

        @NotBlank(message = "Email field is mandatory") 
        @Email(message = "Email address must be valid") 
        String email,

        @NotBlank(message = "Password field is mandatory") 
        @Size(min = 8, message = "Password must have at least 8 characters") 
        String password,

        @NotNull(message = "Role field is mandatory") 
        HashSet<UserRole> roles
) {}
