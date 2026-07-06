package com.controltotal.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI controlTotalOpenAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Control Total API")

                        .description("""
                                Sistema ERP/POS Multiempresa desarrollado
                                con Spring Boot, Arquitectura Hexagonal,
                                DDD y Clean Architecture.
                                """)

                        .version("v1.0.0")

                        .contact(new Contact()

                                .name("Jonathan Tapia")
                                .email("jonas233323@gmail.com")
                        )
                )

                .externalDocs(new ExternalDocumentation()

                        .description("Repositorio del proyecto")
                        .url(""));
    }

}