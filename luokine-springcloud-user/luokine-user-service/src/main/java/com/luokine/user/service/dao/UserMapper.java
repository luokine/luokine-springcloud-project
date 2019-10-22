package com.luokine.user.service.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.user.service.VO.UserVo;
import com.luokine.user.service.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo>{

    @Override
    IPage<UserInfo> pageByQuery(IPage<UserInfo> query);

    IPage<UserInfo> getUserList(UserVo materialQuery);
}
