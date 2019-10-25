package com.luokine.provider.core.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.orm.service.BaseService;
import com.luokine.provider.entity.bean.UserInfo;
import com.luokine.provider.entity.vo.UserRespVO;
import com.luokine.provider.entity.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianziquan123
 * @since 2019-10-24
 */
public interface UserInfoService extends BaseService<UserInfo> {

    IPage<UserInfo> getUserListPage(UserVo user);

    UserInfo getListById(Integer id);

    UserRespVO getUserById(Integer id);
}
