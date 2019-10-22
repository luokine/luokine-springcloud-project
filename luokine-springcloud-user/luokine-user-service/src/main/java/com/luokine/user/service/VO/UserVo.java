package com.luokine.user.service.VO;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luokine.user.service.bean.UserInfo;
import lombok.Data;

/**
 * @author: tiantziquan
 * @create: 2019-10-21 19:27
 */
@Data
public class UserVo extends Page<UserInfo> {

    private Integer userId;
    private String userName;
    private String password;
}
