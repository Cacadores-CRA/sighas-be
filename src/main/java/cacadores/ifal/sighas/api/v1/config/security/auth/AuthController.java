package cacadores.ifal.sighas.api.v1.config.security.auth;

import cacadores.ifal.sighas.api.v1.academic_management.model.dto.user.UserLoginDTO;
import cacadores.ifal.sighas.api.v1.config.security.auth.jwt.JwtDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Tag(name = "Auth", description = "Endpoints for auth related services")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService authService) {
        this.service = authService;
    }

    //Authentication
    @Operation(summary = "Authenticates a user using a username and password", method = "POST")
    @PostMapping
    public ResponseEntity<JwtDTO> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.authenticateUser(userLoginDTO));
    }

}
