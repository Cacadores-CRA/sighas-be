package cacadores.ifal.sighas.api.v1.academic_management.model.dto.user;

import cacadores.ifal.sighas.api.v1.academic_management.model.enums.AppRole;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Set;

//TODO: Implement custom exceptions
@Schema(description = "DTO for creating or updating users")
public record UserRequestDTO(
    @CPF(message = "Invalid CPF")
    String cpf,

    @NotBlank(message = "Invalid name")
    String name,

    @NotBlank(message = "Invalid surname")
    String surname,

    @NotNull(message = "Invalid birthdate")
    //TODO: Convert date format
    LocalDate birthdate,

    @Email(message = "Invalid email address")
    String email,

    //TODO: Implement validation so that it only contain letters
    @NotBlank(message = "Invalid username")
    @Size(message = "Username must have at least 6 characters and 30 characters at maximum", min = 6, max = 30)
    String username,

    @NotBlank()
    @Size(message = "Password must have at least 8 characters and 100 characters at maximum", min = 8, max = 100)
    String password,

    @NotNull(message = "Role field is obligatory")
    @Enumerated(EnumType.STRING)
    Set<AppRole> roles
) {}
