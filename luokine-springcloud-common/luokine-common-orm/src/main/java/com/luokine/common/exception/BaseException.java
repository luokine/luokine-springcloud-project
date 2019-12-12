package com.luokine.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errMessage;

    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey = true;


    /**
     * 构造一个基本异常.
     * @param errMessage
     */
    public BaseException(String errMessage) {
        super(errMessage);
    }

    /**
     * 构造一个基本异常.
     * @param errMessage
     */
    public BaseException(int errorCode , String errMessage) {
        super(errMessage);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     * @param errMessage
     * @param errorCode
     * @param propertiesKey
     */
    public BaseException(int errorCode , String errMessage , boolean propertiesKey) {
        super(errMessage);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(true);
    }

    /**
     * 构造一个基本异常.
     * @param errorCode
     * @param errMessage
     * @param cause
     */
    public BaseException(int errorCode , String errMessage , Throwable cause) {
        super(errMessage , cause);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     * @param errMessage
     * @param errorCode
     * @param propertiesKey
     * @param cause
     */
    public BaseException(int errorCode , String errMessage , boolean propertiesKey , Throwable cause) {
        this(errorCode , errMessage , cause);
        this.setPropertiesKey(true);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}

