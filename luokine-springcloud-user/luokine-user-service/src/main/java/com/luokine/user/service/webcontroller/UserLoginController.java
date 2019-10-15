package com.luokine.user.service.webcontroller;

import com.luokine.user.service.bean.SysUser;
import com.luokine.user.service.service.SysUserService;
import com.luokine.user.service.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:45
 */
@RequestMapping("/user")
@RestController
@Api(tags ="用户接口")
public class UserLoginController {
    @Autowired
    private SysUserService userService;



    @PostMapping("/login")
    @ApiOperation("登录")
    public Map<String,Object> login(String username, String password){

        Map<String,Object> map = new HashMap<>();
        SysUser user = new SysUser(username,password);

        if(userService.login(user)){
            String token = TokenUtil.sign(user);
            if(token != null){
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                return map;
            }
        }

        map.put("code", "0000");
        map.put("message", "认证失败");
        return map;

    }

    @ApiOperation("获取用户列表")
    @GetMapping("/getList")
    public List<SysUser> getList(){

        List userList = userService.getList();
        return userList;

    }

}
