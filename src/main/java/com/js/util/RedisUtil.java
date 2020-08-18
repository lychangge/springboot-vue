package com.js.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate redisTemplate;

    public  boolean expired(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public long getExpired(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public String get(String key) {

        return redisTemplate.opsForValue().get(key).toString();
    }

}
