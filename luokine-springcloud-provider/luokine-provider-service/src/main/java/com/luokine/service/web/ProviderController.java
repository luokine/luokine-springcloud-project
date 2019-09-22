package com.luokine.service.web;

import com.luokine.api.service.ProviderApiService;
import com.luokine.api.vo.SysUser;
import com.luokine.client.web.CustomerClient;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:43
 */
@RestController
public class ProviderController implements ProviderApiService {


    @Value("${server.port}")
    private String port;
    @Autowired
    private CustomerClient customerService;

    @Override
    public String providerHello2() {
        List<String> list=new ArrayList<>();
        CollectionUtils.isEmpty(list);
        String resp = customerService.customerFei();
        return "provider:port="+port+";"+resp;
    }

    @Override
    public List<SysUser> getList() {
        List<SysUser> list=new ArrayList<>();
        SysUser user1=new SysUser();
        user1.setId("1");
        user1.setUsername("luokine1");
        user1.setPassword("123456");
        SysUser user2=new SysUser();
        user2.setId("1");
        user2.setUsername("luokine1");
        user2.setPassword("123456");
        list.add(user1);
        list.add(user2);
        return list;
    }
}
