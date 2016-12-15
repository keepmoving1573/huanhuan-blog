package com.huan.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/12/15 - 22:02
 */
@Configuration
@EnableCaching
public class RedisConfiguration {

    /**
     * jedis
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
        sentinelConfig.master("mymaster");
        sentinelConfig.sentinel("172.16.100.81", 6378).sentinel("172.16.100.81", 6379).sentinel("172.16.100.81", 26379);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig);
        jedisConnectionFactory.setPassword("ptmind");
        jedisConnectionFactory.setDatabase(0);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(3600); // Sets the default expire time (in seconds)
        return cacheManager;
    }

}