package com.luokine.common.exception;


public class ValidationException extends BaseException {

    public ValidationException(String errMessage) {
        super(errMessage);
    }

    public ValidationException(int errorCode, String errMessage) {
        super(errorCode, errMessage);
    }

    public ValidationException(int errorCode, String errMessage, boolean propertiesKey) {
        super(errorCode, errMessage, propertiesKey);
    }

    public ValidationException(int errorCode, String errMessage, Throwable cause) {
        super(errorCode, errMessage, cause);
    }

    public ValidationException(int errorCode, String errMessage, boolean propertiesKey, Throwable cause) {
        super(errorCode, errMessage, propertiesKey, cause);
    }
}

