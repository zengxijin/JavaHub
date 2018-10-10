package com.jack.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/10/10
 * 利用LinkedHashMap实现LRU（最近最少使用）的缓存容器
 * 2个关键点：
 * (1)首先以访问的次序来排序队列；
 * (2)设计淘汰最近最少访问的数据策略，本身LinkedHashMap是有removeEldestEntry的函数的，覆写它就可以了
 *    覆写的逻辑就是超过一定缓存长度就删除最近最少使用的那个Entry;
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LRUCache(int cacheSize) {
        // accessOrder must be true to make sure the list ordered by access, else by insert order
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    public LRUCache() {
        this(16);
    }

    public static <K, V> LRUCache<K, V> buildDefault() {
        return new LRUCache<>();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > cacheSize;
    }
}
