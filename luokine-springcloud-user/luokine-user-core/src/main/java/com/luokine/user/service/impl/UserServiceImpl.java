package com.luokine.user.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import com.luokine.common.model.Vo.Resp;
import com.luokine.common.orm.service.impl.BaseServiceImpl;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.dao.UserMapper;
import com.luokine.user.query.UserVo;
import com.luokine.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: tiantziquan
 * @create: 2019-10-21 19:17
 */

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserInfo> implements UserService {



    @Resource
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public IPage<UserInfo> getUserList(UserVo user) {
        IPage<UserInfo> userList = userMapper.getUserList(user);
        return userList;
    }

    @Override
    public Resp<Boolean> batchInsertUser() {
        List<UserInfo> userList = Lists.newArrayList();
        int num = 25;
        for (int i = 1; i <= num; i++) {
            UserInfo user = new UserInfo();
            user.setUserId(i);
            user.setUserName("luokine" + Integer.valueOf(i).toString());
            user.setPassword(passwordEncoder.encode("123456"));
            user.setDelFlag(Integer.valueOf(0).byteValue());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userList.add(user);
        }
        boolean b=false;
        try {
            b = this.saveBatch(userList, num);
            log.info("保存用户返回结果----->{}", JSON.toJSONString(b));
        } catch (RuntimeException e) {
            log.info("保存用户返回异常----->{}", JSON.toJSONString(e.getMessage()));
        }
        return Resp.ok(b);
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        List<UserInfo> list = this.list();
        return list;
    }

    @Override
    public UserInfo getUserInfoByName(String name) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.equals("name");
        UserInfo one = this.getOne(queryWrapper);
        return one;
    }
}
