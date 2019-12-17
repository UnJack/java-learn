package rpc.exception;

/**
 * Created by jian.jie on 2016/12/23.
 */
public class RpcException extends RuntimeException {

    private String code;
    private String description;

    private RpcException() {
    }

    private RpcException(String code, String description) {
        super(description);
        this.code = code;
        this.description = description;
    }

    public static final RpcException EXCEPTION_000 = new RpcException("000", "远程连接超时");

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
