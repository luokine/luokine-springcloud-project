package com.luokine.getway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: tiantziquan
 * @create: 2019-06
 */
@SpringBootApplication
@EnableZuulProxy
public class GetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetWayApplication.class, args);
    }
}
