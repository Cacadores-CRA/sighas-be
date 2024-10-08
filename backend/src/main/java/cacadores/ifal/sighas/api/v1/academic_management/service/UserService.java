package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.UserRole;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRoleRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserRoleRepository userRoleRepository;
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.repository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    //CREATE
    public UserResponseDTO createUser(UserRequestDTO createUserDTO) {
        return this.toUserResponseDTO(
            repository.save(this.toUser(createUserDTO))
        );
    }

    //READ ALL
    public List<UserResponseDTO> getAllUsers() {
        return repository.findAll().stream().map(this::toUserResponseDTO).collect(Collectors.toList());
    }

    //READ BY ID
    //TODO: Create a custom exception
    public UserResponseDTO getUserById(UUID id) {
        return this.toUserResponseDTO(repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        ));
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
        User user = new User();
        Set<UserRole> roles = new HashSet<>();
        //TODO: create custom exception
        userRequestDTO.roles().forEach(
            role -> {
                roles.add(userRoleRepository.findById(role.ordinal()).orElseThrow(
                        () -> new IllegalArgumentException("Invalid role assignment")
                    )
                );
            }
        );

        user.setCpf(userRequestDTO.cpf());
        user.setName(userRequestDTO.name());
        user.setSurname(userRequestDTO.surname());
        user.setBirthdate(userRequestDTO.birthdate());
        user.setEmail(userRequestDTO.email());
        //TODO: Encrypt password
        user.setPassword(userRequestDTO.password());
        user.setRoles(roles);

        return user;
    }
}
