package com.gerardo.actividadback1.configuracion;

import java.util.Collections;

import com.fasterxml.classmate.TypeResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger {
    @Autowired
    TypeResolver typeResolver;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gerardo.actividadback1.controlador"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Actividad Back 1",
                "Crear un projecto de spring boot, agregarle la configuración de conexión a la base de datos postgrest y crear dos entidades: \n\n\t--producto\n\t--categoria \n\n\n Nota: Los atributos se deja a su discreción solo sigan las buenas practicas de nombrado de tablas y campos vistos en los dias anteriores. ",
                "1.0",
                null,
                new Contact("Gerardo Salazar", null, "gerardo.salazar@banregio.com"),
                null,
                null,
                Collections.emptyList()
        );
    }
}
