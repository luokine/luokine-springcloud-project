package com.luokine.user.service.webcontroller;

import com.luokine.user.service.bean.SysUser;
import com.luokine.user.service.service.SysUserService;
import com.luokine.user.service.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
