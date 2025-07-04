package com.mikael.web;

import com.mikael.web.bo.Order;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @version 1.0
 * @date 2025/6/30
 */


@SpringBootTest
public class Test01 {
    /**
     * 释放锁lua脚本
     */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void main1() {
        Order order = new Order();
        order.setOrder_status("1");
        order.setOrderId("12324");
    }

    @Test
    void test01() {
        String lockKey = "123";
        String UUID = cn.hutool.core.lang.UUID.fastUUID().toString();
        boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey, UUID, 3, TimeUnit.MINUTES);
        if (!success) {
            System.out.println("锁已存在");
        }
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result =(Long)  redisTemplate.execute(redisScript, Collections.singletonList(lockKey), UUID);
        System.out.println(result+"=====");


    }
}
