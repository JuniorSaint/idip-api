package com.idip.idiptecnologia.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
                                                      .select()
                                                      .apis(RequestHandlerSelectors.basePackage("com.idip.idiptecnologia.controllers"))
                                                      .build()
                                                      .securityContexts(Arrays.asList(securityContext()))
                                                      .securitySchemes(Arrays.asList(apiKey()))
                                                      .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Projeto Academia")
                                   .description("projeto de estudo")
                                   .version("1.0")
                                   .contact(contact())
                                   .build();
    }

    private Contact contact() {
        return new Contact("DiPi", "http://www.idip.com.br", "junior@dipi.com.br");
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "Header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    private List<SecurityReference> defaultAuth() {
        var authorizationScope = new AuthorizationScope("global", "accessEverything");
        var scopes = new AuthorizationScope[1];
        scopes[0] = authorizationScope;
        var reference = new SecurityReference("JWT", scopes);
        List<SecurityReference> auths = new ArrayList<>();
        auths.add(reference);
        return auths;
    }
}
