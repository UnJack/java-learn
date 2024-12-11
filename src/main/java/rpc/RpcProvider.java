package rpc;

import rpc.service.HelloService;
import rpc.service.HelloServiceImpl;

/**
 * User: jimjian
 * Date: 16-5-3 上午11:14
 * 服务发布者
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        DubboRpc.export(service, 1234);
    }

}

