package com.example.redisdemo.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

/**
 * @author komiles@163.com
 * @date 2020-05-22 14:54
 */
@Service
public class RedisDbHelperImpl<HK,T> implements RedisBbHelper<HK,T> {

    private RedisTemplate<String, T> redisTemplate;

    private HashOperations<String,HK,T> hashOperations;

    private ListOperations<String,T> listOperations;

    private ZSetOperations<String,T> zSetOperations;

    private SetOperations<String,T> setOperations;

    private ValueOperations<String,T> valueOperations;

    @Autowired
    public RedisDbHelperImpl(RedisTemplate<String,T> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     * Hash结构 添加元素
     *
     * @param key key
     * @param hashKey hashKey
     * @param domain 元素
     */
    @Override
    public void hashPut(String key, HK hashKey, T domain) {
        hashOperations.put(key,hashKey,domain);
    }

    /**
     * Hash结构 获取指定key所有键值对
     */
    @Override
    public Map<HK, T> hashFindAll(String key) {
        return hashOperations.entries(key);
    }

    /**
     * Hash结构 获取单个元素
     */
    @Override
    public T hashGet(String key, HK hashKey) {
        return hashOperations.get(key,hashKey);
    }

    @Override
    public void hashRemove(String key, HK hashKey) {
        hashOperations.delete(key,hashKey);
    }

    /**
     * List结构 向尾部(Right)添加元素
     */
    @Override
    public Long listPush(String key, T domain) {
        return listOperations.rightPush(key,domain);
    }

    /**
     * List结构 向头部(Left)添加元素
     */
    @Override
    public Long listUnshift(String key, T domain) {
        return listOperations.leftPush(key,domain);
    }

    /**
     * List结构 获取所有元素
     */
    @Override
    public List<T> listFindAll(String key) {
        if(!redisTemplate.hasKey(key)){
            return null;
        }
        return listOperations.range(key,0,listOperations.size(key));
    }

    /**
     * List结构 移除并获取数组第一个元素
     */
    @Override
    public T listLPop(String key) {
        return listOperations.leftPop(key);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 设置过期时间
     *
     * @param key 键
     * @param timeout 时间
     * @param timeUnit 时间单位
     */
    @Override
    public boolean expirse(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key,timeout,timeUnit);
    }
}
