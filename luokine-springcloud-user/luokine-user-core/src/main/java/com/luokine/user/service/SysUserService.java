package com.luokine.user.service;

import com.luokine.user.bean.SysUser;

import java.util.List;


public interface SysUserService {
    public boolean login(SysUser user);

    public List<SysUser> getList();
}
