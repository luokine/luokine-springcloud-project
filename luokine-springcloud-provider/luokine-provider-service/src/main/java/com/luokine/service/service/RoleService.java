package com.luokine.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.api.UserRoleServiceClient;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.model.Vo.Resp;
import com.luokine.provider.entity.vo.ProviderRoleReqVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-10-28 17:09
 */
@Component
public class RoleService {

    @Autowired
    private UserRoleServiceClient userRoleServiceClient;


    public Resp<IPage<UserRole>> getRolePage(ProviderRoleReqVo vo) {
        UserRoleReqVo vo2 = new UserRoleReqVo();
        BeanUtils.copyProperties(vo, vo2);
        Resp<IPage<UserRole>> page = userRoleServiceClient.getRolePage(vo2);
        return page;
    }

    public Resp<List<UserRole>> getRolePageList(ProviderRoleReqVo vo) {
        UserRoleReqVo vo2 = new UserRoleReqVo();
        BeanUtils.copyProperties(vo, vo2);
        Resp<List<UserRole>> list = userRoleServiceClient.getRolePageList(vo2);
        return list;

    }

//    public List<UserRole> getRoleList() {
//        return userRoleServiceClient.getRoleList();
//    }

    public UserRole getRoleById(@RequestParam Integer id) {
        UserRole role = userRoleServiceClient.getRoleById(id);
        return role;
    }
}
