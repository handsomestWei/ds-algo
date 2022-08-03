package com.wjy.dsalgo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 简单的LRU最近最少使用缓存实现。继承jdk的LinkedHashMap重写removeEldestEntry方法
 * 
 * @author weijiayu
 * @date 2022/8/3 11:43
 */
public class LinkedHashMapLRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, null);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
