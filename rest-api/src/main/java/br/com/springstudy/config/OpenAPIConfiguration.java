package br.com.springstudy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI myOpenAPI() {

        Info info = new Info()
                .title("Rest-API")
                .version("1.0.0")
                .description("Microserviço de estudos"); //http://localhost:8090/api/estudos/swagger-ui/index.html#/

        return new OpenAPI().info(info);
    }
}
