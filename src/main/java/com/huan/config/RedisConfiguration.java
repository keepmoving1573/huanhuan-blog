package com.huan.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

/**
 * @author <a href="mailto:huanhuan.zhan@qunar.com">詹欢欢</a>
 * @since 2018/10/14 - 11:00
 */
@Configuration
//@EnableCaching
public class RedisConfiguration {

    /**
     * redis集群，sentinel
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
        sentinelConfig.setMaster("mymaster");
        //redis会自动把127.0.0.1转成本机ip
        String nodes = "100.80.180.38:26379";
//        String nodes = "100.80.180.38:26379,100.80.180.38:26380";  //多个用逗号隔开
        String[] nodeArray = nodes.split(",");
        for (String node : nodeArray) {
            String ip = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            sentinelConfig.sentinel(ip, port);
        }
        /* 简写配置
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
                .sentinel("100.80.180.38", 26379)
                .sentinel("100.80.180.38", 26380);
                */
        //master访问密码
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig);
        jedisConnectionFactory.setPassword("123456");
        jedisConnectionFactory.setDatabase(0);
        return jedisConnectionFactory;
    }

    /**
     * redisTemplate
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }


}
