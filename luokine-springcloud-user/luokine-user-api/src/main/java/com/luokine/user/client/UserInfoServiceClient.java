package com.luokine.user.client;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.model.Vo.Resp;
import com.luokine.common.model.Vo.Result;
import com.luokine.user.bean.SysUser;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.query.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author: tiantziquan
 * @create: 2019-10-23 14:20
 */
@FeignClient("luokine-user-service")
public interface UserInfoServiceClient {

    @PostMapping("/user/getUserList")
    @ApiOperation("分页查询用户信息")
    Result<IPage<UserInfo>> getUserListPage(@RequestBody UserVo userVo);

    @GetMapping("/user/addUser")
    @ApiOperation("批量添加用户")
    Resp<Boolean> addUserBatch();

    @PostMapping("/user/login")
    @ApiOperation("登录")
    Resp<Map<String,Object>> login(@RequestParam String username, @RequestParam String password);

    @ApiOperation("获取用户列表")
    @GetMapping("/suser/getList")
    List<SysUser> getUserList();
}
