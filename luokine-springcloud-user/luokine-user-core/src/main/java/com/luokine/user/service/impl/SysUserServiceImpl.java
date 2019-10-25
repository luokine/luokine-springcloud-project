package com.luokine.user.service.impl;

import com.luokine.user.bean.UserInfo;
import com.luokine.user.service.SysUserService;
import com.luokine.user.bean.SysUser;
import com.luokine.user.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:20
 */
@Component
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public boolean login(SysUser user) {
        String username = user.getUsername();
//        String password = passwordEncoder.encode(user.getPassword());
        UserInfo info = userService.getUserInfoByName(user.getUsername());
        boolean login=false;
        if(info.equals(null)){
            return login;
        }
        login=passwordEncoder.matches(user.getPassword(),info.getPassword());
        login=user.getUsername().equals(info.getUserName());
        if(login){
            return login;
        }

//        List<UserInfo> list = userService.getUserInfoList();
//        if (CollectionUtils.isEmpty(list)) {
//            return false;
//        }
//        boolean b = false;
//        for (UserInfo sysUser : list) {
//            boolean matche1 = passwordEncoder.matches(user.getPassword(),sysUser.getPassword());
//            boolean matche2 = false;
//            if (sysUser.getUserName().equals(username)) {
//                matche2 = true;
//            }
//            if (matche1 && matche2) {
//                b = true;
//                break;
//            }
//        }
//        if (b) {
//            return true;
//        }
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
