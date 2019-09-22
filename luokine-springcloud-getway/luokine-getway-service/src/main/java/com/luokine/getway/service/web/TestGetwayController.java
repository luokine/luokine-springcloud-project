package com.luokine.getway.service.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tiantziquan
 * @create: 2019-07-05 17:57
 */
@RestController
@RequestMapping("/getway")
public class TestGetwayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    private String testGetWay(){
        return "getway: port:"+port;
    }


}
