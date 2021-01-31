package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public ApiInfo crateApiInfo() {
		return new ApiInfoBuilder().
				title("Batch application")
				.description("develoed by ashok it")
				.version("1.0")
				.build();
	}
	
	@Bean
	public Docket crateDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("batch api")
				.apiInfo(crateApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ashoikt"))
				.paths(PathSelectors.any())
				.build();
	}
}
