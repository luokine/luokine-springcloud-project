package com.luokine.user.service.service.impl;

import com.luokine.user.service.bean.SysUser;
import com.luokine.user.service.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:20
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean login(SysUser user) {
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        List<SysUser> list = getList();
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        boolean b = false;
        for (SysUser sysUser : list) {
            boolean matche1 = passwordEncoder.matches(sysUser.getPassword(), password);
            boolean matche2 = false;
            if (sysUser.getUsername().equals(username)) {
                matche2 = true;
            }
            if (matche1 && matche2) {
                b = true;
                break;
            }
        }
        if (b) {
            return true;
        }
        return false;
    }

    @Override
    public List<SysUser> getList() {
        SysUser user1 = new SysUser("luokine1", "12345");
        SysUser user2 = new SysUser("luokine2", "12345");
        SysUser user3 = new SysUser("luokine3", "12345");
        SysUser user4 = new SysUser("luokine", "12345");
        List<SysUser> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return list;
    }
}
