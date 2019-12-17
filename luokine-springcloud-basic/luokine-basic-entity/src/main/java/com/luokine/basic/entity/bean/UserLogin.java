package com.luokine.basic.entity.bean;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 表名：luokine_user..user_login
*/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@Table(name = "luokine_user.user_login")
public class UserLogin {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "password")
    private String password;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String MOBILE_NO = "mobileNo";

    public static final String DB_MOBILE_NO = "mobile_no";

    public static final String PASSWORD = "password";

    public static final String DB_PASSWORD = "password";

    /**
     * 带默认值的实例
    */
    public static UserLogin defaultInstance() {
        UserLogin instance = new UserLogin();
        return instance;
    }
}