package com.java.base.exception;

/**
 * User: jimjian
 * Date: 16-11-30 下午10:22
 */
public class MallException extends BaseException {

    private MallException(){}
    private MallException(String defineCode, String message) {
        super();
        this.defineCode = defineCode;
        this.message = message;
    }

    public static final MallException MALL400002 = new MallException("MALL400002", "单页请求数量过大");
    public static final MallException MALL400009 = new MallException("MALL400009", "必传参数为空");

    @Override
    public String toString() {
        return "MallException{" +
                "defineCode='" + defineCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
