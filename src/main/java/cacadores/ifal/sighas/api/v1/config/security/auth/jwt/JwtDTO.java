package cacadores.ifal.sighas.api.v1.config.security.auth.jwt;

import java.time.Instant;

public record JwtDTO(
        String accessToken,
        String tokenType,
        Instant expiresIn
) {}
