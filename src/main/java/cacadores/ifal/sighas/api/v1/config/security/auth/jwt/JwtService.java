package cacadores.ifal.sighas.api.v1.config.security.auth.jwt;

import cacadores.ifal.sighas.api.v1.academic_management.model.entity.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;
    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }
    public JwtDTO generateJwt(Authentication authentication) {
        Instant now = Instant.now();
        long expirySeconds = 7_200L;

        List<String> userRoles = authentication
            .getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("SIGHAS Backend")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expirySeconds))
            .subject(authentication.getName())
            .claim("roles", userRoles)
            .build();

        String jsonWebToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        User authenticatedUser = (User) authentication.getPrincipal();

        return new JwtDTO(
            authenticatedUser.getName(),
            authenticatedUser.getSurname(),
            authenticatedUser.getEmail(),
            jsonWebToken,
            "Bearer Token",
            now.plusSeconds(expirySeconds)
        );
    }
}
