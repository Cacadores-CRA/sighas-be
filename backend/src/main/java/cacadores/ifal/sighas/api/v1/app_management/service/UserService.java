package cacadores.ifal.sighas.api.v1.app_management.service;

import org.hibernate.mapping.List;
import org.hibernate.validator.constraints.UUID;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cacadores.ifal.sighas.api.v1.app_management.model.dto.user.UserRequestDTO;
import cacadores.ifal.sighas.api.v1.app_management.model.dto.user.UserResponseDTO;
import cacadores.ifal.sighas.api.v1.app_management.model.entity.user.User;
import cacadores.ifal.sighas.api.v1.app_management.repoistory.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    public final UserRepository repository;
    public final PasswordEncoder passwordEncoder;
    public UserService(UserRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    //CREATE
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userCreateDTO) {
        User user = new User(
                userCreateDTO.name(),
                userCreateDTO.surname(),
                userCreateDTO.email(),
                passwordEncoder.encode(userCreateDTO.password()),
                userCreateDTO.roles()
        );

        return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getRoles()
        );
    }

    //READ ALL

    //READ BY ID

    //READ BY EMAIL

    //UPDATE

    //DELETE

    private UserResponseDTO userToResponseDTO(User user) {
        
    }

}
