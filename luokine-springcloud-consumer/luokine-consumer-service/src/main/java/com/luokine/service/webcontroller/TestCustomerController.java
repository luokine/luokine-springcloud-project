package com.luokine.service.webcontroller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.api.vo.SysUser;
import com.luokine.client.ProviderClientService;
import com.luokine.common.model.Vo.Result;
import com.luokine.service.service.ConsumerService;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.query.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ConsumerService consumerService;

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
        UserVo userVo=new UserVo();
        userVo.setCurrent(3l);
        userVo.setSize(5l);
        Result<IPage<UserInfo>> listPage = consumerService.getUserListPage(userVo);
        log.info("分页获取用户列表->:[{}]",JSON.toJSONString(listPage));
        return list;
    }

    @ApiOperation("分页获取用户列表")
    @PostMapping("/getUsetListPage")
    public Result<IPage<UserInfo>> getUserListPage(@RequestBody UserVo userVo){
        Result<IPage<UserInfo>> userListPage = consumerService.getUserListPage(userVo);
        return userListPage;
    }
}
