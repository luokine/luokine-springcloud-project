package com.luokine.basic.service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.core.service.UserLoginService;
import com.luokine.basic.core.service.UserRoleService;
import com.luokine.basic.entity.bean.UserLogin;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.model.Vo.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-10-25 18:24
 */
@RestController
@Slf4j
@RequestMapping("/basic")
@Api(tags = "基础调用provider")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/getRolePage")
    @ApiOperation("分页获取角色 resp")
    public Resp<IPage<UserRole>> getRolePage(@RequestBody UserRoleReqVo vo) {
        IPage<UserRole> userRolePage = userRoleService.getUserRolePage(vo);
        return Resp.ok(userRolePage);
    }

    @PostMapping("/getRolePageList")
    @ApiOperation("分页获取角色 Resp list")
    public Resp<List<UserRole>> getRolePageList(@RequestBody UserRoleReqVo vo) {
        List<UserRole> list = userRoleService.list();
        return Resp.ok(list);
    }

    @PostMapping("/getRolePageList2")
    @ApiOperation("获取角色 list")
    public List<UserRole> getRoleList(@RequestBody UserRoleReqVo vo) {
        List<UserRole> list = userRoleService.list();
        return list;
    }

    @GetMapping("/getRoleById")
    @ApiOperation("获取角色 id")
    public UserRole getRoleById(@RequestParam Integer id) {
        UserRole user = userRoleService.getUserRoleById(id);
        UserLogin userLogin = new UserLogin();
        Example example = new Example(UserLogin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(UserLogin.ID,1);
        UserLogin one = userLoginService.getOne(example);
        System.out.println("one = " + one);
        return user;
    }



}
