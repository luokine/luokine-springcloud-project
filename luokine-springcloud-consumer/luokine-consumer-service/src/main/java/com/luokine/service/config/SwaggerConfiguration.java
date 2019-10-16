//package com.luokine.service.config;
//
//import com.google.common.collect.Lists;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: tiantziquan
// * @create: 2019-10-15 16:57
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//    @Bean
//    public Docket createRestApi() {
//        // =============添加head参数start=========
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        tokenPar.name("Authorization").description("AccessToken令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        // =============添加head参数end=========
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.luokine.service.webcontroller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("消费者服务")
//                .description("luokine-consumer")
//                .termsOfServiceUrl("http://localhost:8002/")
//                .contact("767050075@qq.com")
//                .version("2.0")
//                .build();
//    }
//
//
////    @Bean(value = "groupRestApi")
////    @Order(value = 1)
////    public Docket groupRestApi() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(apiInfo())
////                .groupName("分组接口")
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.luokine.service.webcontroller"))
////                .paths(PathSelectors.any())
////                .build().securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
////    }
////    private ApiKey apiKey() {
////        return new ApiKey("BearerToken", "Authorization", "header");
////    }
////
////    private SecurityContext securityContext() {
////        return SecurityContext.builder()
////                .securityReferences(defaultAuth())
////                .forPaths(PathSelectors.regex("/.*"))
////                .build();
////    }
////
////    private List<SecurityReference> defaultAuth() {
////        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
////        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
////        authorizationScopes[0] = authorizationScope;
////        List<SecurityReference> securityReferences = new ArrayList<>();
////        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
////        return securityReferences;
////    }
//
//}
