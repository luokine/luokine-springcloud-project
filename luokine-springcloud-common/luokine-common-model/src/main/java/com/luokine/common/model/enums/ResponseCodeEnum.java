package com.luokine.common.model.enums;

public enum ResponseCodeEnum {
    SUCCESS(1, "操作已成功！"),
    NOT_LOGIN(-1, "请重新登陆！"),
    FAIL(0, "操作失败，系统异常！"),
    NO_LOGIN(401, "请先登录"),
    USER_NOT_EXIST(20001, "账户不存在"),
    USER_NOT_LOGGED_IN(20002, "用户未登陆"),
    USER_ACCOUNT_ERROR(20003, "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20004, "用户账户已被禁用"),
    USER_HAS_EXIST(20005, "用户已存在"),
    DATA_EXCEPTION(5000, "操作失败,数据异常"),
    PERMISSION_NO_ACCESS(70001, "没有访问权限");

    private Integer code;
    private String message;

    private ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
