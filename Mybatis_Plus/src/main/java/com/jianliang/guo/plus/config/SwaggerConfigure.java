package com.jianliang.guo.plus.config;

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

@EnableSwagger2
@Configuration
public class SwaggerConfigure {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jianliang.guo.plus.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MyBatis-Plus Example")
                .description("Spring Boot整合MyBatis-Plus 3.2.0 示例")
                .termsOfServiceUrl("https://www.baidu.com")
                .contact(new Contact("create jianliang", "https://www.baidu.com", "jianliang.guo@mtime.com"))
                .version("3.2.0")
                .license("MIT-License")
                .licenseUrl("https://mit-license.org/")
                .build();
    }

}