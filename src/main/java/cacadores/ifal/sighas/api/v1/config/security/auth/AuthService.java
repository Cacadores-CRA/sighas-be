package cacadores.ifal.sighas.api.v1.config.security.auth;

import cacadores.ifal.sighas.api.v1.academic_management.exception.auth.AuthenticationFailedException;
import cacadores.ifal.sighas.api.v1.academic_management.model.dto.user.UserLoginDTO;
import cacadores.ifal.sighas.api.v1.config.security.auth.jwt.JwtDTO;
import cacadores.ifal.sighas.api.v1.config.security.auth.jwt.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthService(final JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtDTO authenticateUser(UserLoginDTO userLoginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    userLoginDTO.username(),
                    userLoginDTO.password()
                )
            );

            return jwtService.generateJwt(authentication);
        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("Username or password incorrect!");
        }
    }
}
