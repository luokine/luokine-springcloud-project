package com.luokine.user.service.service;

import com.luokine.user.service.bean.SysUser;

import java.util.List;


public interface SysUserService {
    public boolean login(SysUser user);

    public List<SysUser> getList();
}
