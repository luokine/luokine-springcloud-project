package com.luokine.provider.entity.vo;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luokine.provider.entity.bean.UserInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: tiantziquan
 * @create: 2019-10-21 19:27
 */
@Data
public class UserVo extends Page<UserInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userName;
    private String password;
}
