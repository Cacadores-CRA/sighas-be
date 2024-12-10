package cacadores.ifal.sighas.api.v1.academic_management.exception.auth;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
