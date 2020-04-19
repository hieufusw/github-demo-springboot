package com.hieunv.common.exception;

public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;

    private String code;
    private String simpleMessage;

    public BusinessException(String code, String simpleMessage) {
        super();
        this.code = code;
        this.simpleMessage = simpleMessage;
    }

    public BusinessException() {
        super();
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    /**
     * @param code
     */
    public BusinessException(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}






