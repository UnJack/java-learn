package com.java.base.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;

/**
 * User: jimjian
 * Date: 16-3-11下午3:31
 */
public class test_Zookeeper {

    @Test
    public void testNode() throws IOException, KeeperException, InterruptedException {
        // 创建一个与服务器的连接 需要(服务端的 ip+端口号)(session过期时间)(Watcher监听注册)
        ZooKeeper zk = new ZooKeeper("172.16.11.23:2181", 3000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });

        // 创建一个目录节点
        /**
         * CreateMode:
         *  PERSISTENT (持续的，相对于EPHEMERAL，不会随着client的断开而消失)
         *       PERSISTENT_SEQUENTIAL（持久的且带顺序的）
         *       EPHEMERAL (短暂的，生命周期依赖于client session)
         *       EPHEMERAL_SEQUENTIAL  (短暂的，带顺序的)
         */
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath", false, null)));

        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath", true));

        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(zk.getChildren("/testRootPath", true));

        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne", "this is zookeeper!jack".getBytes(), -1);
        byte[] datas = zk.getData("/testRootPath/testChildPathOne", true, null);
        String str = new String(datas, "utf-8");
        System.out.println(str);

        //删除整个子目录   -1代表version版本号，-1是删除所有版本
        //zk.delete("/testRootPath/testChildPathOne", -1);
        System.out.println(zk.getChildren("/testRootPath", true));
        System.out.println(str);

        //判断结点是否存在
        Stat stat = zk.exists("/testRootPath/testChildPathOne", false);
        if (stat == null) {

        } else {
            System.out.println("");
        }

    }

    @Test
    public void delete() throws IOException, KeeperException, InterruptedException {

//        ZooKeeper zk = new ZooKeeper("10.58.88.228:2182", 30000, new Watcher() {
//            @Override
//            public void process(WatchedEvent event) {
//                System.out.println("已经触发了" + event.getType() + "事件！");
//                System.out.println("路径:" + event.getPath());
//            }
//        });
//        System.out.println(new String(zk.getData("/b", true, null), "utf-8"));

//        zk.setData("/b", "this is jane".getBytes(), -1);

        ZooKeeper zk = new ZooKeeper("172.16.11.23:2181", 30000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getPath().equals("/auth/test5")) {
                    System.out.println("已经触发了" + event.getType() + "事件！");
                    System.out.println("路径:" + event.getPath());
                }
            }
        });

//        zk.delete("/testRootPath", -1);

//        ZkDTO zkDTO = new ZkDTO();
//        zkDTO.setDomain("123");
//        zkDTO.setCode("456");
//
//        zk.create("/testRootPath/zkDto3", "3333".toString().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        Map map=new HashMap<>();
//        map.put("111","222");
//        zk.create("/testRootPath/zkDto1", map.toString().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        byte[] datas = zk.getData("/auth/test5", false, null);
        String str = new String(datas, "utf-8");
        System.out.println(str);
    }

    class ZkDTO {
        private String domain;
        private String code;

        public ZkDTO() {
        }

        public ZkDTO(String domain, String code) {
            this.domain = domain;
            this.code = code;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "ZkDTO{" +
                    "domain='" + domain + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }
}
