package com.luokine.service.webcontroller;

import com.luokine.api.vo.SysUser;
import com.luokine.client.ProviderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-09-05 18:15
 */
@RestController
@RequestMapping("/consumer")
public class TestCustomerController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProviderClientService providerClientService;

    @GetMapping("/web/customer")
    public String customerFei() {
        return "customer:"+port;
    }


    @GetMapping("/web/customer2")
    public String customerFei2() {
        return "customer2:"+port;
    }

    @GetMapping("/getList")
    public List<SysUser> getList(){
        List<SysUser> list = providerClientService.getList();
        return list;
    }
}
