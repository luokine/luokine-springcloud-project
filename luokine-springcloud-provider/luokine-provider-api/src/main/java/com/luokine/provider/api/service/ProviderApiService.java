package com.luokine.provider.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.model.Vo.Resp;
import com.luokine.provider.api.vo.SysUser;
import com.luokine.provider.entity.bean.UserInfo;
import com.luokine.provider.entity.vo.UserRespVO;
import com.luokine.provider.entity.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/provider")
public interface ProviderApiService {

    @GetMapping("/hello")
    public String providerHello();

    @GetMapping("/getList")
    public List<SysUser> getList();

    @PostMapping("/userListPage")
    @ApiOperation("分页获取用户数据")
    Resp<IPage<UserInfo>> getUserListPage(@RequestBody UserVo user);

    @GetMapping("/getUserById")
    @ApiOperation("根据Id获取用户xml")
    UserRespVO getUserById(@RequestParam Integer id);
}
