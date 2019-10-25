//package com.luokine.service.web;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.luokine.common.model.Vo.Resp;
//import com.luokine.provider.core.service.UserInfoService;
//import com.luokine.provider.entity.bean.UserInfo;
//import com.luokine.provider.entity.vo.UserRespVO;
//import com.luokine.provider.entity.vo.UserVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author: tiantziquan
// * @create: 2019-10-25 10:48
// */
//@RestController
//@Slf4j
//@RequestMapping("/provider")
//@Api(tags = "提供用户接口")
//public class ProviderUserController {
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @PostMapping("/userListPage")
//    @ApiOperation("分页获取用户数据")
//    public Resp<IPage<UserInfo>> getUserListPage(@RequestBody UserVo user){
//        IPage<UserInfo> listPage = userInfoService.getUserListPage(user);
//        return Resp.ok(listPage);
//    }
//
//
//    @GetMapping("/getUserListById")
//    @ApiOperation("根据Id获取用户auto")
//    public Resp<UserInfo> getUserList(@RequestParam Integer id){
//        UserInfo info = userInfoService.getListById(id);
//        return Resp.ok(info);
//    }
//
//    @GetMapping("/getUserById")
//    @ApiOperation("根据Id获取用户xml")
//    public UserRespVO getUserById(@RequestParam Integer id){
//        UserRespVO user = userInfoService.getUserById(id);
//        return user;
//    }
//}
