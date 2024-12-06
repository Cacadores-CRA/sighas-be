package cacadores.ifal.sighas.api.v1.config.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(Authentication authentication) {
        return "Token";
    }
}
