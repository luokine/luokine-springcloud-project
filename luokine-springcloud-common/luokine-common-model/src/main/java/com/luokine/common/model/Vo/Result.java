package com.luokine.common.model.Vo;

import com.luokine.common.model.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * @author: tiantziquan
 * @create: 2019-10-22 16:16
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
    }

    public Result(T data) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public Result(RestStatus statusCodes, T data) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.code = statusCodes.code();
        this.msg = statusCodes.message();
        if (data != null) {
            this.data = data;
        }

    }

    public Result(T data, String msg) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.data = data;
        this.msg = msg;
    }

    public Result(Throwable throwable) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.msg = throwable.getMessage();
        this.code = ResponseCodeEnum.FAIL.getCode();
    }

    public Result(T data, ResponseCodeEnum responseCode) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.data = data;
        this.code = responseCode.getCode();
        this.msg = responseCode.getMessage();
    }

    public Result(Throwable throwable, ResponseCodeEnum code) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.msg = throwable.getMessage();
        this.code = code.getCode();
    }

    public static <T> Result.ResultBuilder<T> builder() {
        return new Result.ResultBuilder();
    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    public Result(final Integer code, final String msg, final T data) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMessage();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public Result<T> setCode(final Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public Result<T> setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public static class ResultBuilder<T> {
        private Integer code;
        private String msg;
        private T data;

        ResultBuilder() {
        }

        public Result.ResultBuilder<T> code(final Integer code) {
            this.code = code;
            return this;
        }

        public Result.ResultBuilder<T> msg(final String msg) {
            this.msg = msg;
            return this;
        }

        public Result.ResultBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public Result<T> build() {
            return new Result(this.code, this.msg, this.data);
        }

        public String toString() {
            return "Result.ResultBuilder(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
        }
    }
}

