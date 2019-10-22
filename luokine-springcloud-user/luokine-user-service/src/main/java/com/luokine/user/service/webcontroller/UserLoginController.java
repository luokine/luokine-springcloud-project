package com.luokine.user.service.webcontroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import com.luokine.user.service.VO.UserVo;
import com.luokine.user.service.bean.SysUser;
import com.luokine.user.service.bean.UserInfo;
import com.luokine.user.service.service.SysUserService;
import com.luokine.user.service.service.UserService;
import com.luokine.user.service.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    private static final Logger log = LogManager.getLogger(UserLoginController.class);
    @Autowired
    private SysUserService userService;

    @Autowired
    private UserService userService2;


    @GetMapping("/getUserList")
    public IPage<UserInfo> getList2(){
        UserVo user=new UserVo();
        user.setCurrent(2);
        IPage<UserInfo> userList = userService2.getUserList(user);
        return userList;
    }

    @GetMapping("/getUserList2")
    public IPage<UserInfo> getList3(){
        return null;
    }
    @GetMapping("/addUser")
    public Boolean addUser(){
        List<UserInfo> userList = Lists.newArrayList();
        int num=25;
        for (int i = 1; i <= num; i++) {
            UserInfo user = new UserInfo();
            user.setUserId(i);
            user.setUserName("luokine"+Integer.valueOf(i).toString());
            user.setPassword("123456");
            user.setDelFlag(Integer.valueOf(0).byteValue());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userList.add(user);
        }
        boolean b = userService2.saveBatch(userList);
        return b;
    }

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
