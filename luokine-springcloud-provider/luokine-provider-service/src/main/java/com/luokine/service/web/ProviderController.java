package com.luokine.service.web;

import com.luokine.api.service.ProviderApiService;
import com.luokine.api.vo.SysUser;
import org.apache.commons.collections.CollectionUtils;
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


    @Override
    public String providerHello() {
        List<String> list=new ArrayList<>();
        CollectionUtils.isEmpty(list);
        return "provider:port="+port+";";
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
