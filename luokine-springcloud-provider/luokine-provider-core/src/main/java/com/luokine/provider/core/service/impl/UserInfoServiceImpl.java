package com.luokine.provider.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.orm.service.impl.BaseServiceImpl;
import com.luokine.provider.core.dao.UserInfoMapper;
import com.luokine.provider.core.service.UserInfoService;
import com.luokine.provider.entity.bean.UserInfo;
import com.luokine.provider.entity.vo.UserRespVO;
import com.luokine.provider.entity.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tianziquan123
 * @since 2019-10-24
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Resource
    private UserInfoMapper userMapper;


    @Override
    public IPage<UserInfo> getUserListPage(UserVo user) {
        IPage<UserInfo> userList = userMapper.getUserListPage(user);
        return userList;
    }

    @Override
    public UserInfo getListById(Integer id) {
        return userMapper.getListById(id);
    }

    @Override
    public UserRespVO getUserById(Integer id) {
        UserInfo user = userMapper.getUserById(id);
        UserRespVO respVO=new UserRespVO();
        BeanUtils.copyProperties(user,respVO);
        return respVO;
    }
}
