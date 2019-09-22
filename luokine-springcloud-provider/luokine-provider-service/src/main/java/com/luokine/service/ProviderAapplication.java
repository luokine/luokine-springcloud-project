package com.luokine.service;

import com.luokine.client.web.CustomerClientPKG;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:37
 */
@SpringBootApplication
@EnableFeignClients(basePackageClasses = {CustomerClientPKG.class},value = {})
public class ProviderAapplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAapplication.class,args);
    }
}
