package org.learn.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StopWatch;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * User: jimjian
 * Date: 16-3-18 下午4:57
 * http://www.importnew.com/19117.html
 */
public class testHongBao {
    static String host = "localhost";
    //    集群
//    static String host = "10.58.88.228";
    static int honBaoCount = 1_0_0000;

    static int threadCount = 20;

    // 红包队列
    static String hongBaoList = "hongBaoList";
    // 红包消费队列
    static String hongBaoConsumedList = "hongBaoConsumedList";
    // 红包排重队列
    static String hongBaoConsumedMap = "hongBaoConsumedMap";

    static Random random = new Random();

    //  -- 函数：尝试获得红包，如果成功，则返回json字符串，如果不成功，则返回空
//  -- 参数：红包队列名， 已消费的队列名，去重的Map名，用户ID
//  -- 返回值：nil 或者 json字符串，包含用户ID：userId，红包ID：id，红包金额：money
    static String tryGetHongBaoScript =
//          "local bConsumed = redis.call('hexists', KEYS[3], KEYS[4]);\n"
//          + "print('bConsumed:' ,bConsumed);\n"
//          如果用户已抢过红包，则返回nil
            "if redis.call('hexists', KEYS[3], KEYS[4]) ~= 0 then\n"
                    + "return nil\n"
                    + "else\n"
                    + "local hongBao = redis.call('rpop', KEYS[1]);\n"
//                  + "print('hongBao:', hongBao);\n"
                    + "if hongBao then\n"
                    + "local x = cjson.decode(hongBao);\n"
                    + "x['userId'] = KEYS[4];\n"
                    + "local re = cjson.encode(x);\n"
                    + "redis.call('hset', KEYS[3], KEYS[4], KEYS[4]);\n"
                    + "redis.call('lpush', KEYS[2], re);\n"
                    + "return re;\n"
                    + "end\n"
                    + "end\n"
                    + "return nil";
    static StopWatch watch = new StopWatch();

    public static void main(String[] args) throws InterruptedException {
//      testEval();
        generateTestData();
        testTryGetHongBao();
    }

    static public void generateTestData() throws InterruptedException {
        Jedis jedis = new Jedis(host);
        // 清空所有数据
        jedis.flushAll();
        final CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; ++i) {
            final int temp = i;
            Thread thread = new Thread() {
                public void run() {
                    Jedis jedis = new Jedis(host);
                    int per = honBaoCount / threadCount;
                    JSONObject object = new JSONObject();
                    for (int j = temp * per; j < (temp + 1) * per; j++) {
                        object.put("id", j);
                        object.put("money", j);
                        jedis.lpush(hongBaoList, object.toJSONString());
                    }
                    latch.countDown();
                }
            };
            thread.start();
        }
        latch.await();
    }

    /**
     * 消费红包
     *
     * @throws InterruptedException
     */
    static public void testTryGetHongBao() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(threadCount);
        System.err.println("start:" + System.currentTimeMillis() / 1000);
        watch.start();
        for (int i = 0; i < threadCount; ++i) {
            final int temp = i;
            Thread thread = new Thread() {
                public void run() {
                    Jedis jedis = new Jedis(host);
                    String sha = jedis.scriptLoad(tryGetHongBaoScript);
                    int j = honBaoCount / threadCount * temp;
                    while (true) {
                        Object object = jedis.eval(tryGetHongBaoScript, 4, hongBaoList, hongBaoConsumedList, hongBaoConsumedMap, "" + j);
                        j++;
                        if (object != null) {
//                            System.out.println("get hongBao:" + object);
                        } else {
                            //已经取完了
                            if (jedis.llen(hongBaoList) == 0) {
                                System.out.println("红包已领完!" + Thread.currentThread().getName() + "{}" + j);
                                break;
                            }
                        }
                    }
                    latch.countDown();
                }
            };
            thread.start();
        }

        latch.await();
        watch.stop();

        System.err.println("time:" + watch.getTotalTimeSeconds());
        System.err.println("speed:" + honBaoCount / watch.getTotalTimeSeconds());
        System.err.println("end:" + System.currentTimeMillis() / 1000);
    }
}