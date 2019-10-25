package com.luokine.basic.core.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.orm.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    IPage<UserRole> getUserRolePage(UserRoleReqVo vo);

    UserRole getUserRoleById(@Param("id") Integer id);
}
