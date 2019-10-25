package com.luokine.basic.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.basic.core.dao.UserRoleMapper;
import com.luokine.basic.core.service.UserRoleService;
import com.luokine.basic.entity.bean.UserRole;
import com.luokine.basic.entity.vo.UserRoleReqVo;
import com.luokine.common.orm.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: tiantziquan
 * @create: 2019-10-25 18:02
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public IPage<UserRole> getUserRolePage(UserRoleReqVo vo) {
        IPage<UserRole> rolePage = userRoleMapper.getUserRolePage(vo);
        return rolePage;
    }

    @Override
    public UserRole getUserRoleById(Integer id) {
        UserRole role = userRoleMapper.getUserRoleById(id);
        return role;
    }
}
