package com.luokine.basic.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.model.Vo.Resp;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("luokine-basic-service")
public interface UserRoleServiceClient {

    @PostMapping("/basic/getRolePage")
    @ApiOperation("分页获取角色 resp")
    Resp<IPage<UserRole>> getRolePage(@RequestBody UserRoleReqVo vo);


    @PostMapping("/basic/getRolePageList")
    @ApiOperation("分页获取角色 Resp list")
   Resp<List<UserRole>> getRolePageList(@RequestBody UserRoleReqVo vo);


    @PostMapping("/basic/getRolePageList")
    @ApiOperation("获取角色 list")
    List<UserRole> getRoleList(@RequestBody UserRoleReqVo vo);

    @GetMapping("/basic/getRoleById")
    @ApiOperation("获取角色 id")
    UserRole getRoleById(@RequestParam Integer id);




}
