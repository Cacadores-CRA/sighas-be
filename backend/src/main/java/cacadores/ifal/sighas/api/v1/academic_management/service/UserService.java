package cacadores.ifal.sighas.api.v1.academic_management.service;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;
import cacadores.ifal.sighas.api.v1.academic_management.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    //CREATE
    public UserResponseDTO createUser(UserRequestDTO createUserDTO) {
        return this.userToUserResponseDTO(
            repository.save(createUserDTO.toUser())
        );
    }
    //READ ALL
    //READ BY ID
    //UPDATE
    //DELETE

    //ENTITY TO RESPONSE DTO
    private UserResponseDTO userToUserResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getCpf(),
            user.getName(),
            user.getSurname(),
            user.getBirthdate(),
            user.getEmail(),
            user.getRoles()
        );
    }
}
