package com.luokine.service;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.luokine.basic.api.UserRoleServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:37
 */
@SpringBootApplication
@EnableSwaggerBootstrapUI
@MapperScan(basePackages = "com.luokine", annotationClass = Mapper.class)
@ComponentScan(basePackages = {"com.luokine"})
@EnableFeignClients(basePackageClasses = {UserRoleServiceClient.class})
@Slf4j
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        log.info("luokine-provider-service----------------> is start!");
    }
}
