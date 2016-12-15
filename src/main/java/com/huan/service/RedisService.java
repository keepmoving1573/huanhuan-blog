package com.huan.service;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:47
 */
public interface RedisService {

    void set(String key, Object value);

    <T> T get(String key, Class<T> clazz);

    void setWithTimeout(String key, String value, long timeout, TimeUnit timeunit);

    void delete(String key);


}
