package com.luokine.service.web;

import com.alibaba.fastjson.JSON;
import com.luokine.api.service.ProviderApiService;
import com.luokine.api.vo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-08-14 17:43
 */
@RestController
@Slf4j
public class ProviderController implements ProviderApiService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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
        log.info("用户列表：[{}]", JSON.toJSONString(list));
        logger.info("用户列表 -->logger：[{}]", JSON.toJSONString(list));
        return list;
    }
}
