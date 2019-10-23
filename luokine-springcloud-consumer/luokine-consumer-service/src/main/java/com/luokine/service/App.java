package com.luokine.service;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.luokine.client.ProviderClientServicePKG;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = {
//        SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class ,
        DataSourceHealthIndicatorAutoConfiguration.class
})
@EnableSwaggerBootstrapUI
@EnableFeignClients(basePackageClasses = {ProviderClientServicePKG.class},value = {"com.luokine.user.client"})
//@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
