package com.huan.service.impl;

import com.alibaba.fastjson.JSON;
import com.huan.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/10/28 - 16:15
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperations;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public void set(String key, Object value) {
        String redisValue = "";
        if (value instanceof String) {
            redisValue = (String) value;
        } else {
            redisValue = JSON.toJSONString(value);
        }
        valueOperations.set(key, redisValue);
    }

    /**
     * 获取指定key的缓存
     *
     * @param key
     */
    public <T> T get(String key, Class<T> clazz) {
        if (clazz.equals(String.class)) {
            return (T) valueOperations.get(key);
        } else {
            Object value = JSON.parseObject(valueOperations.get(key), clazz);
            return (T) value;
        }
    }

    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param timeout  过期时间
     * @param timeunit 时间单位
     */
    public void setWithTimeout(String key, String value, long timeout, TimeUnit timeunit) {
        String redisValue = "";
        if (value instanceof String) {
            redisValue = (String) value;
        } else {
            redisValue = JSON.toJSONString(value);
        }
        valueOperations.set(key, redisValue, timeout, timeunit);
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

}
