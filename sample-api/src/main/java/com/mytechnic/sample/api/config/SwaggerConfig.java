package com.mytechnic.sample.api.config;

import com.mytechnic.sample.api.controller.api.ApiControllerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		Set<String> producesList = new HashSet<>();
		producesList.add("application/json");

		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage(ApiControllerAdvice.class.getPackage().getName()))
			.paths(PathSelectors.ant("/api/**"))
			.build().apiInfo(apiInfo()).produces(producesList);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Spring Boot Configurations")
			.contact(new Contact("mytechnic", "https://mytechnic.com", "mytechnic@gmail.com"))
			.build();
	}
}
