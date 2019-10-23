package com.luokine.user.bean;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: tiantziquan
 * @create: 2019-10-21 18:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {
    private Integer userId;

    private String userName;

    private String password;

    private Byte delFlag;

    private Date createTime;

    private Date updateTime;

}
