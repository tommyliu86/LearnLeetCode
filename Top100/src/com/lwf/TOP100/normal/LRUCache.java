package com.lwf.TOP100.normal;

import java.util.*;

/**
 * author Administrator
 * time 2019-11-07-22:49
 */
public class LRUCache {
    Queue<Integer> keyQueue = new LinkedList<>();
    Integer capacity;
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            keyQueue.remove(key);
            keyQueue.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            if (map.get(key)!=value ){

                keyQueue.remove(key);
            }
        } else if (keyQueue.size() >= capacity) {
            int keyNeedRemove = keyQueue.poll();
            map.remove(keyNeedRemove);
        }

        keyQueue.add(key);
        map.put(key, value);
    }

}
