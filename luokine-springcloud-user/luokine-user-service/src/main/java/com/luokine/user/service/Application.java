package com.luokine.user.service;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.luokine.client.ProviderClientServicePKG;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableEurekaClient
@MapperScan(basePackages = "com.luokine.user.dao", annotationClass = Mapper.class)
@ComponentScan(basePackages = {"com.luokine"})
@EnableFeignClients(basePackageClasses = {ProviderClientServicePKG.class},value = {})
@EnableSwaggerBootstrapUI
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("luokine-user-service----------------> is start!");
    }

}
