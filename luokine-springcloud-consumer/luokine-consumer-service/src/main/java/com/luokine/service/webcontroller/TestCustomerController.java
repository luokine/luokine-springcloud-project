package com.luokine.service.webcontroller;

import com.alibaba.fastjson.JSON;
import com.luokine.api.vo.SysUser;
import com.luokine.client.ProviderClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-09-05 18:15
 */
@RestController
@RequestMapping("/consumer")
@Api(tags = "customer Test接口")
@Slf4j
public class TestCustomerController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProviderClientService providerClientService;

    @ApiOperation("获取customer 端口")
    @GetMapping("/web/customer")
    @ApiImplicitParam(value = "参数1", name = "param", required = false)
    public String customerFei(@RequestParam Integer param) {
        String format = String.format("customer:%s --->", param);
        log.info("获取customer接口 获取入参：[{}]", JSON.toJSONString(format));
        return format+port;
    }


    @ApiOperation("获取provider 用户列表")
    @GetMapping("/getList")
    public List<SysUser> getList(){
        List<SysUser> list = providerClientService.getList();
        return list;
    }
}
