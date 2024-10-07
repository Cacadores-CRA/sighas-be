package cacadores.ifal.sighas.api.v1.academic_management.controller;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserRequestDTO;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.UserResponseDTO;
import cacadores.ifal.sighas.api.v1.academic_management.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService service;
    public UserController(UserService userService) {
        this.service = userService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO userCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(userCreateDTO));
    }

    //READ ALL
    //READ BY ID
    //UPDATE
    //DELETE
}
