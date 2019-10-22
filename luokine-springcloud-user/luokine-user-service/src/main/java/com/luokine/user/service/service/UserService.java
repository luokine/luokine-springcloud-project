package com.luokine.user.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.user.service.VO.UserVo;
import com.luokine.user.service.bean.UserInfo;

public interface UserService extends BaseService<UserInfo>{

    IPage<UserInfo> getUserList(UserVo user);
}
