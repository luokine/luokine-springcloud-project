package com.luokine.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.model.Vo.Result;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.client.UserInfoServiceClient;
import com.luokine.user.query.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: tiantziquan
 * @create: 2019-10-23 15:28
 */
@Service
public class ConsumerService {
    @Autowired
    private UserInfoServiceClient userInfoServiceClient;

    public Result<IPage<UserInfo>> getUserListPage(UserVo userVo){
        Result<IPage<UserInfo>> listPage = userInfoServiceClient.getUserListPage(userVo);
        return listPage;
    }
}
