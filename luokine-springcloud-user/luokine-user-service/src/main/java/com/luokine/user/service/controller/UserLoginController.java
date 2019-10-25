package com.luokine.user.service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import com.luokine.common.model.Vo.Resp;
import com.luokine.common.model.Vo.Result;
import com.luokine.common.model.enums.ResponseCodeEnum;
import com.luokine.user.bean.SysUser;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.query.UserVo;
import com.luokine.user.service.utils.TokenUtil;
import com.luokine.user.service.SysUserService;
import com.luokine.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags ="用户接口")
public class UserLoginController {

//    private static final Logger log = LogManager.getLogger(UserLoginController.class);
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserService userService;


    @PostMapping("/getUserList")
    @ApiOperation("分页查询用户信息")
    public Result<IPage<UserInfo>> getUserListPage(@RequestBody UserVo userVo){
        Result result=new Result();
        IPage<UserInfo> userList = userService.getUserList(userVo);
        result.setMsg(ResponseCodeEnum.SUCCESS.getMessage());
        result.setCode(ResponseCodeEnum.SUCCESS.getCode());
        result.setData(userList);
        return result;
    }


    @GetMapping("/addUser")
    @ApiOperation("批量添加用户")
    public Resp<Boolean> addUserBatch(){
        Resp<Boolean> b = userService.batchInsertUser();
        return b;
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public Resp<Map<String,Object>> login(String username, String password){
        SysUser user = new SysUser(username,password);
        boolean login = sysUserService.login(user);
        String token = TokenUtil.sign(user);
        Map<String,Object> map=new HashMap<>();
        if(token != null){
            map.put("message", "认证成功");
            map.put("token", token);
            map.put("登录状态:",login);
        }
        return Resp.ok(map);

    }

    @ApiOperation("获取用户列表")
    @GetMapping("/getList")
    public List<SysUser> getList(){
        List userList = sysUserService.getList();
        return userList;

    }

    @GetMapping("/getUserById")
    @ApiOperation("根据Id获取用户")
    public Resp<UserInfo> getUserList(@RequestParam Integer id){
        UserInfo info = userService.getListById(id);
        return Resp.ok(info);
    }

}
