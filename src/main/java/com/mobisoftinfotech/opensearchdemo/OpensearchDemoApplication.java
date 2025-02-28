package com.mobisoftinfotech.opensearchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;

@SpringBootApplication
public class OpensearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpensearchDemoApplication.class, args);
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()
                .addParameters("Content-Type-Header",
                        new Parameter().in("header").schema(new StringSchema())
                                .name("Content-Type")))
                .info(new Info().title("OpenSearch Java client with Spring Boot API").version("1.0")
                        .description(
                                "This is a sample spring rest api documentation. Please update project name in title")
                        .termsOfService("/terms-and-conditions")
                        .license(new License().name("Other")
                                .url("http://springdoc.org")));

    }
   
}
