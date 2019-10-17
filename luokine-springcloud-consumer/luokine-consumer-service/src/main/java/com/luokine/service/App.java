package com.luokine.service;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.luokine.client.ProviderClientServicePKG;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableSwagger2
@EnableSwaggerBootstrapUI
@EnableFeignClients(basePackageClasses = {ProviderClientServicePKG.class},value = {})
//@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
