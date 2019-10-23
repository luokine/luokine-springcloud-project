package com.luokine.user.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.orm.mapper.BaseMapper;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.query.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    @Override
    IPage<UserInfo> pageByQuery(IPage<UserInfo> query);

    IPage<UserInfo> getUserList(UserVo materialQuery);
}
