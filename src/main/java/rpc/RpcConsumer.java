package rpc;

import rpc.service.HelloService;

/**
 * User: jimjian
 * Date: 16-5-3 上午11:15
 * 服务消费者
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = DubboRpc.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }

}

