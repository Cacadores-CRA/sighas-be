package cacadores.ifal.sighas.api.v1.config.security.auth.jwt;

import java.time.Instant;

public record JwtDTO(
        String userName,
        String userSurname,
        String userEmail,
        String accessToken,
        String tokenType,
        Instant expiresIn
) {}
