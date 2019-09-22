package com.luokine.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tiantziquan
 * @create: 2019-06-14 16:02
 */
@RestController
public class CustomerController implements CustomerService{


    @Value("${server.port}")
    private String port;

    @Override
    public String customerFei() {
        return "customer:"+port;
    }
}
