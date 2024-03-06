package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	@Bean
    public OpenAPI JuegoOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Juego API")
                .description("Documentación del listado de juegos LucaSteam")
                .version("v1.0")
                .contact(new Contact().name("BugsBusters").
                        url("https://BugsBusters.es").email("Bugs@Busters.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Gestion de juegos para la plataforma LucaSteam")
                .url("https://LucaSteam.es"));
    }
}
