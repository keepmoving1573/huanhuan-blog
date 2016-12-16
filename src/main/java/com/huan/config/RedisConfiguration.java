package com.huan.config;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/12/15 - 22:02
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends AbstractConfiguration {

    /**
     * jedis
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        logger.debug("Configuring RedisConnectionFactory");
        super.resolver = new RelaxedPropertyResolver(super.env, "spring.redis.");
        if (resolver.getProperty("database") == null) {
            logger.error("Your redis connection configuration is incorrect! The application" +
                            " cannot start. Please check your Spring profile, current profiles are: {}",
                    Arrays.toString(env.getActiveProfiles()));
            throw new ApplicationContextException("RedisConnection connection is not configured correctly");
        }

        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
        sentinelConfig.master(resolver.getProperty("sentinel.master"));
        String nodes = resolver.getProperty("sentinel.nodes");
        String[] nodeArray = nodes.split(",");
        for (String node : nodeArray) {
            String ip = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            sentinelConfig.sentinel(ip, port);
        }
        System.out.println("------------sentinel------------" + JSON.toJSONString(sentinelConfig));

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfig);
        jedisConnectionFactory.setPassword(resolver.getProperty("password"));
        jedisConnectionFactory.setDatabase(Integer.parseInt(resolver.getProperty("database")));
        return jedisConnectionFactory;
    }

    /**
     * redisTemplate
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    /**
     * cacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(3600); // Sets the default expire time (in seconds)
        return cacheManager;
    }

}