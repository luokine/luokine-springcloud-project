package com.luokine.provider.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: tiantziquan
 * @create: 2019-10-25 14:56
 */
@Data
public class UserRespVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String password;
}
