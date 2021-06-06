package com.sagarkhati.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.sagarkhati.restservices"))
				.paths(PathSelectors.ant("/users/**")).build();
	}

	/*
	 * Swagger Metadata URL - http://localhost:8080/v2/api-docs Swagger UI URL -
	 * http://localhost:8080/swagger-ui.html
	 * 
	 */

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User Management service").description("List all API's of User Management")
				.version("2.0").contact(new Contact("Sagar Khati", "https://sagarkhati.com", "skhati@gmail.com"))
				.license("Sagar").licenseUrl("https://xyz.com").termsOfServiceUrl("Open Source").build();
	}
}
