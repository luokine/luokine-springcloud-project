package com.luokine.user.service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.client.ProviderClientService;
import com.luokine.common.model.Vo.Resp;
import com.luokine.provider.api.vo.SysUser;
import com.luokine.provider.entity.bean.UserInfo;
import com.luokine.provider.entity.vo.UserRespVO;
import com.luokine.provider.entity.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-10-25 11:14
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "调用provider服务")
public class UserProviderController {

//    @Autowired
//    private ProviderUserServiceClient providerUserServiceClient;

    @Autowired
    private ProviderClientService providerClientService;

    @PostMapping("/provider/userListPage")
    @ApiOperation("分页查询用户")
    public Resp<IPage<UserInfo>> getUserListPage(@RequestBody UserVo user){
        Resp<IPage<UserInfo>> listPage = providerClientService.getUserListPage(user);
        return listPage;
    }

    @GetMapping("/provider/getPort")
    @ApiOperation("获取端口")
    public Resp<List<SysUser>> getProviderPort(){
        List<SysUser> list = providerClientService.getList();
        return Resp.ok(list);
    }

    @GetMapping("/provider/getUserById")
    @ApiOperation("根据Id获取用户xml")
    public UserRespVO getUserById(@RequestParam Integer id){
        return providerClientService.getUserById(id);
    }

}
