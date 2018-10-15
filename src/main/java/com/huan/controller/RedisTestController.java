package com.huan.controller;

import com.huan.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:huanhuan.zhan@ptmind.com">詹欢欢</a>
 * @since 2017/3/24 - 15:26
 */
@RestController
@RequestMapping(value = "/redis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "set", method = RequestMethod.GET)
    public String set(String key, String value) {
        redisService.setWithTimeout(key, value, 5, TimeUnit.SECONDS);
        return "key:"+key+", value:"+value;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(String key) {
        String value = redisService.get(key, String.class);
        return value;
    }
}
