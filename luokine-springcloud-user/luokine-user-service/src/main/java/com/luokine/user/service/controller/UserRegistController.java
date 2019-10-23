package com.luokine.user.service.controller;

import com.luokine.user.bean.SysUser;
import com.luokine.user.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:45
 */
@RestController
@Api(tags = "注册接口")
public class UserRegistController {
    @Autowired
    private SysUserService userService;


    @PostMapping(value="/getList1")
    public List<SysUser> getList(){

        List userList = userService.getList();
        return userList;

    }

}
