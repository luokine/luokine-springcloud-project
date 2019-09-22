package com.luokine.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tiantziquan
 * @create: 2019-06-14 16:01
 */
@RequestMapping("/customer")
public interface CustomerService {

    @GetMapping("/hello")
    public String customerFei();
}
