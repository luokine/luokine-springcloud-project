package com.luokine.service.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luokine.basic.api.UserRoleServiceClient;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.model.Vo.Resp;
import com.luokine.provider.entity.vo.ProviderRoleReqVo;
import com.luokine.service.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-10-28 16:47
 */
@RestController
@RequestMapping("/provider")
@Slf4j
@Api(tags = "basic 接口")
public class UserRoleController {

    @Autowired
    private UserRoleServiceClient userRoleServiceClient;

    @Autowired
    private RoleService roleService;

    @PostMapping("/basic/getRolePage")
    @ApiOperation("分页获取角色 resp")
    Resp<IPage<UserRole>> getRolePage(@RequestBody ProviderRoleReqVo vo){
        return roleService.getRolePage(vo);
    }

    @PostMapping("/basic/getRolePage2")
    @ApiOperation("分页获取角色 resp")
    Resp<IPage<UserRole>> getRolePage2(@RequestBody UserRoleReqVo vo){
        return userRoleServiceClient.getRolePage(vo);
    }

    @PostMapping("/basic/getRolePage3")
    @ApiOperation("分页获取角色 resp")
    Resp<Page<UserRole>> getRolePageList(@RequestBody UserRoleReqVo vo){
        return userRoleServiceClient.getPageRoleList(vo);
    }

    @PostMapping("/basic/getRolePageList")
    @ApiOperation("分页获取角色 Resp list")
    public Resp<List<UserRole>> getRolePageList(@RequestBody ProviderRoleReqVo vo){
        log.info("params:--> [{}]", JSON.toJSONString(vo));
        Resp<List<UserRole>> list = roleService.getRolePageList(vo);
        return list;

    }

    @GetMapping("/basic/getRolePageList2")
    @ApiOperation("获取角色 list")
    public List<UserRole> getRoleList(){
        return roleService.getRoleList();
    }

    @GetMapping("/basic/getRoleById")
    @ApiOperation("获取角色 id")
    public UserRole getRoleById(@RequestParam Integer id){
        UserRole role = roleService.getRoleById(id);
        return role;
    }



}