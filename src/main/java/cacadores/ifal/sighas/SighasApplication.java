package cacadores.ifal.sighas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "SIGHAS",
		version = "1.0.0",
		description = "Sistema Integrado de Gestão de Horários e Alocação de Salas (SIGHAS)"
	)
)
@SpringBootApplication
@SecurityScheme(name = "jwtAuthentication", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class SighasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SighasApplication.class, args);
	}
}
