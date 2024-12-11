package com.java.base.nosql.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by jian.jie on 2016/12/13.
 */
public class RedisTest extends TestBase {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println("[string] = " + valueOperations.get("msg") + " [string.length] = " + valueOperations.size("msg"));

        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", "jimjian1");
        listOperations.rightPush("list", "jimjian2");
        listOperations.set("list", 2, "jimjian3");
        List list = listOperations.range("list", 0, -1);
        for (Object object : list)
            System.out.println("[list] = " + object);

        BoundListOperations boundListOperations = redisTemplate.boundListOps("list");
        System.out.println("[boundListOperations.leftPop()] = " + boundListOperations.leftPop());

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset", "2270", Double.parseDouble(simpleDateFormat.format(new Date())));
        Set set = zSetOperations.reverseRange("zset", 0, -1);
        for (Object object : set)
            System.out.println("[set] = " + object);

        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("hash", "name", "jimjian");
        hashOperations.put("hash", "address", "北京市朝阳区国贸79");
        hashOperations.put("hash", "age", "24");
        Set set1 = hashOperations.keys("hash");
        for (Object object : set1)
            System.out.println("[hash] = " + hashOperations.get("hash", object));
    }
}
