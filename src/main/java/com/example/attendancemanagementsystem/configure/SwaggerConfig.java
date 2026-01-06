package com.example.attendancemanagementsystem.configure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /***
     * Access the Swagger UI
     * Run your application and access the Swagger UI, typically at http://localhost:8080/swagger-ui/index.html. Other common URLs include http://localhost:8080/swagger-ui/ or http://localhost:8080/swagger-ui.html. The raw API documentation is at http://localhost:8080/v3/api-docs.
     * Add Annotations
     * Enhance your documentation with Swagger annotations in your controllers to describe endpoints, parameters, and responses. Key annotations include @Tag, @Operation, @Parameter, @ApiResponses, and @ApiResponse.
     * @return
     */

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Attendance Management System")
                        .description("List of all APIs for the application")
                        .version("1.0"));
    }
}