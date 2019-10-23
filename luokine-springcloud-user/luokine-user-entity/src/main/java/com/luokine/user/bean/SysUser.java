package com.luokine.user.bean;

import lombok.Data;

/**
 * @author: tiantziquan
 * @create: 2019-06-17 19:19
 */
@Data
public class SysUser {
    private String id;
    private String username;
    private String password;
    public SysUser(String username, String password){
        this.username = username;
        this.password = password;
    }
}
