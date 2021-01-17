package com.xumengqi.reme.base.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Redis 操作工具类
 * @author xumengqi
 * @date 2021/1/3 22:53
 */
@Component
public class RedisUtils<T> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final TimeUnit timeUnit;

    public RedisUtils() {
        timeUnit = TimeUnit.SECONDS;
    }

    public RedisUtils(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public T get(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return (T) value;
    }

    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, T value, long expireTime) {
        if (expireTime < 0) {
            throw new IllegalArgumentException("Expire time is less than 0");
        }
        redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
    }

    public long getExpire(String key) {
        Long expireTime = redisTemplate.getExpire(key, timeUnit);
        if (expireTime == null) {
            throw new IllegalArgumentException("Expire time is null");
        }
        return expireTime;
    }

    public void expire(String key, long expireTime) {
        redisTemplate.expire(key, expireTime, timeUnit);
    }

    public boolean hasKey(String key) {
        Boolean isHasKey = redisTemplate.hasKey(key);
        if (isHasKey == null) {
            throw new IllegalArgumentException("Has key is null");
        }
        return isHasKey;
    }

    public void delete(String... keys) {
        if (keys == null) {
            throw new IllegalArgumentException("There is no key to delete");
        }
        List<String> keyList = Arrays.stream(keys).collect(Collectors.toList());
        if (keyList.size() == 1) {
            redisTemplate.delete(keyList.get(0));
            return;
        }
        redisTemplate.delete(keyList);
    }

    public void increment(String key, long delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta is less than 0");
        }
        redisTemplate.opsForValue().increment(key, delta);
    }

    public void decrement(String key, long delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta is less than 0");
        }
        redisTemplate.opsForValue().increment(key, -delta);
    }

}
