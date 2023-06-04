package com.obcurso.ejercicio8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Documentando con Swagger",
                "Dependencia SpringFox Boot Starter para la documentacion",
                "1.0.0",
                "http://www.google.com",
                new Contact("Alexis", "https://www.linkedin.com/in/alexismasin/","AlexisMasin86@gmail.com"),
                "OpenSource",
                "http://www.google.com",
                Collections.emptyList());
    }
}
