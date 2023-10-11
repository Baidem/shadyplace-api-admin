package com.shadyplace.apiadmin.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {

    @Bean
    public OpenAPI DocConfig() {
            return new OpenAPI()
                    .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                    .components(new Components().addSecuritySchemes(
                            "Bearer Authentication", createAPIKeyScheme()
                    ))
                    .info(new Info()
                            .title("ShadyPlace Admin API")
                            .description("User management")
                            .version("V1.0.0")
                            .contact(new Contact()
                                    .name("Vincent P.")
                                    .email("baidem@gmail.com"))
                    );
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }


}
