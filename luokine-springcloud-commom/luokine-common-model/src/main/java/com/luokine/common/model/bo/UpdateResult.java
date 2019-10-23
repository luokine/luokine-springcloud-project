package com.luokine.common.model.bo;

/**
 * @author: tiantziquan
 * @create: 2019-10-22 15:06
 */
public class UpdateResult {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public UpdateResult() {
    }

    public UpdateResult(int code) {
        this(code, null);
    }

    public UpdateResult(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * code
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
