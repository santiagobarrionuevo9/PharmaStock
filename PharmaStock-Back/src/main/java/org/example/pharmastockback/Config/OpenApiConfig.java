package org.example.pharmastockback.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI pharmastockOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PharmaStock API")
                        .description("API de gestión de stock farmacéutico (lotes, vencimientos, ubicaciones)")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo PharmaStock")
                                .email("dev@pharmastock.local"))
                        .license(new License()
                                .name("Private / Client Use")));
    }
}