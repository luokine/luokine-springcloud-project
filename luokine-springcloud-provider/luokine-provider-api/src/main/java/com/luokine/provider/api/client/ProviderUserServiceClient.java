//package com.luokine.provider.api.client;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.luokine.common.model.Vo.Resp;
//import com.luokine.provider.entity.bean.UserInfo;
//import com.luokine.provider.entity.vo.UserRespVO;
//import com.luokine.provider.entity.vo.UserVo;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author: tiantziquan
// * @create: 2019-10-25 10:19
// */
//@FeignClient("luokine-provider-service")
//public interface ProviderUserServiceClient {
//
//    @PostMapping("/provider/userListPage")
//    @ApiOperation("分页获取用户数据")
//    Resp<IPage<UserInfo>> getUserListPage(@RequestBody UserVo user);
//
//    @GetMapping("/provider/getUserById")
//    @ApiOperation("根据Id获取用户xml")
//    UserRespVO getUserById(@RequestParam Integer id);
//}
