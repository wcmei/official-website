package com.hl.official.website.service;

/**
 * @author wcmei
 * @date 2019-12-14
 * @description
 */
public interface RedisService {

    void set(String key, Object value);

    void set(String key, Object value, int seconds);

    void delete(String key);

    String get(String key);

    boolean hasKey(String key);
}
