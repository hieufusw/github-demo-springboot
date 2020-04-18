package com.hieunv.common.exception;

public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;

    private String code;
    public BusinessException(String authenticationUserPasswordInvalid, String s) {
        super();
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
