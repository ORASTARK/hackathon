package com.bosch.s4t.hackathon;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	//@Value("${swagger.enabled}")
	private boolean enableSwagger = true;
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		//.globalOperationParameters(setHeaderToken())
		        .apiInfo(apiInfo())
		        .enable(enableSwagger)
		        .select()    
		        .apis(RequestHandlerSelectors.any())     // All path
		        //.apis(RequestHandlerSelectors.basePackage("com.bosch.s4t.srm.controllers")) // Controller path
		        .paths(PathSelectors.any())
		        .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API documentation of Smart External Customer Portal")
                .description("Use this documentation as a reference how to interact with app's API")
                //.contact(new Contact("allen","null","name@example.com"))
                .version("0.1")
                .termsOfServiceUrl("http://localhost:8080/demo/")
                .build();
    }
   
    private List<Parameter> setHeaderToken() {
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	//tokenPar.name("X-Auth-Token")
    	tokenPar.name("Authorization")
    			.description("JWT")
    			.modelRef(new ModelRef("string"))
    	        .parameterType("header")
    	        .required(false)
    	        .build();
    
    	pars.add(tokenPar.build());
    	return pars;
    }

}
