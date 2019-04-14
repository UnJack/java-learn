package com.java.base.exception;

/**
 * User: jianjie
 * Date: 16-11-30 下午10:22
 */
public class BaseException extends RuntimeException {

    protected String defineCode;
    protected String message;

    public BaseException() {
    }

    public String getDefineCode() {
        return defineCode;
    }

    public void setDefineCode(String defineCode) {
        this.defineCode = defineCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}