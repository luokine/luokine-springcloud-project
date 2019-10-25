package com.luokine.basic.service;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableSwaggerBootstrapUI
@MapperScan(basePackages = "com.luokine.basic.core.dao", annotationClass = Mapper.class)
@ComponentScan(basePackages = {"com.luokine.**"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.luokine.basic.api"})
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("luokine-provider-service----------------> is start!");
    }

}
