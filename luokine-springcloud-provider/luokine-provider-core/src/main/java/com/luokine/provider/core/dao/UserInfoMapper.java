package com.luokine.provider.core.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.orm.mapper.BaseMapper;
import com.luokine.provider.entity.bean.UserInfo;
import com.luokine.provider.entity.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianziquan123
 * @since 2019-10-24
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfo> getUserListPage(UserVo materialQuery);

    UserInfo getListById(@Param("id") Integer id);

    UserInfo getUserById(@Param("id") Integer id);

}
