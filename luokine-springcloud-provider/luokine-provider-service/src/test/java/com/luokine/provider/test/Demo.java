package com.luokine.provider.test;

import com.alibaba.fastjson.JSON;
import com.luokine.provider.entity.bean.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author: tiantziquan
 * @create: 2019-10-24 11:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo.class)
@AutoConfigureMockMvc
public class Demo {

    private static final Jedis jedis=new Jedis("127.0.0.1",6379);

    @Test
    public void testRedisAdd(){
        jedis.set("redis","jedis");
        System.out.println("jedis = " + jedis.get("redis"));
    }

    @Test
    public void addRdisUser(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserName("luokine");
        jedis.set("json", JSON.toJSONString(userInfo));
        System.out.println("userInfo = " + userInfo);
    }

}
