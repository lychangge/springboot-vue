package com.js.test;

import com.js.util.RedisUtil;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestRedis {
    @Resource
    private RedisUtil redisUtil;

    @Test
    public void testStringset(){
        System.out.println(redisUtil.set("hello123","hello"));
        System.out.println(redisUtil.get("hello123"));
    }
}
