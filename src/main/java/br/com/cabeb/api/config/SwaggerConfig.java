package br.com.cabeb.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@EnableWebMvc
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(List.of(apiKey())).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.cabeb.api.java"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(apiInfoMetaData());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("🔒 api de autenticação cabeb sistema")
                .description("documentação da api autenticação.")
                .contact(new Contact("Brendson", "https://www.linkedin.com/in/brendson/", "brendson.dev@gmail.com"))
                .license("MIT license")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("1.0.0")
                .build();
    }
}