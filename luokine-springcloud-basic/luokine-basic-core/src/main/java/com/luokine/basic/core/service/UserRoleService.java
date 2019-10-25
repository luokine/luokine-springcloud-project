package com.luokine.basic.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.orm.service.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {

    IPage<UserRole> getUserRolePage(UserRoleReqVo vo);


    UserRole getUserRoleById(@Param("id") Integer id);




}
