package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.exception.user.UserUUIDNotFoundException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.user.UserRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.user.UserResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRoleRepository;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//TODO: Add @Transactional annotation on methods
public class UserService {
    private final UserRepository repository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder
    ) {
        this.repository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //CREATE
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO createUserDTO) {
        return this.toUserResponseDTO(
            repository.save(this.toUser(createUserDTO))
        );
    }

    //READ ALL
    public List<UserResponseDTO> getAllUsers() {
        return repository.findAll().stream()
                                   .map(this::toUserResponseDTO)
                                   .collect(Collectors.toList());
    }

    //READ BY ID
    public UserResponseDTO getUserById(UUID id) {
        return this.toUserResponseDTO(
            repository.findById(id).orElseThrow(
                () -> new UserUUIDNotFoundException(
                    String.format("User with UUID '%s' not found", id)
                )
            )
        );
    }

    //UPDATE
    //TODO: Create a custom exception
    public UserResponseDTO updateUser(UUID id, UserRequestDTO userUpdateDTO) {
        User savedUser = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        
        savedUser.setCpf(userUpdateDTO.cpf());
        savedUser.setName(userUpdateDTO.name());
        savedUser.setSurname(userUpdateDTO.surname());
        savedUser.setBirthdate(userUpdateDTO.birthdate());
        savedUser.setEmail(userUpdateDTO.email());
        //TODO: Encrypt password
        savedUser.setPassword(userUpdateDTO.password());
        savedUser.setRoles(
            //TODO: Implement custom exception
            userUpdateDTO.roles().stream()
                    .map(role -> userRoleRepository.findById(role.ordinal()).orElseThrow(
                            () -> new IllegalArgumentException("Invalid role assignment")
                    ))
                    .collect(Collectors.toSet())
        );

        return this.toUserResponseDTO(repository.save(savedUser));
    }
    
    //DELETE
    public void deleteUser(UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            //TODO: Implement custom exception
            throw new RuntimeException("User not found");
        }
    };


    private UserResponseDTO toUserResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getCpf(),
            user.getName(),
            user.getSurname(),
            user.getBirthdate(),
            user.getEmail(),
            user.getRoles().stream().map(UserRole::getRole).collect(Collectors.toSet())
        );
    }

    private User toUser(UserRequestDTO userRequestDTO) {
        return new User(
            userRequestDTO.cpf(),
            userRequestDTO.name(),
            userRequestDTO.surname(),
            userRequestDTO.birthdate(),
            userRequestDTO.email(),
            passwordEncoder.encode(userRequestDTO.password()),
            userRequestDTO.roles().stream().map(UserRole::new).collect(Collectors.toSet())
        );
    }
}
