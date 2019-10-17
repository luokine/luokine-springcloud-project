package com.luokine.service;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:37
 */
@SpringBootApplication
@EnableSwaggerBootstrapUI
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
