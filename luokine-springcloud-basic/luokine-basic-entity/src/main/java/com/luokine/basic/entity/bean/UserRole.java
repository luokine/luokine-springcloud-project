package com.luokine.basic.entity.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author: tiantziquan
 * @create: 2019-10-25 17:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserRole extends Model<UserRole> {

    private Integer roleId;

    private String roleName;

    private Integer userId;

    private String  userName;


}
