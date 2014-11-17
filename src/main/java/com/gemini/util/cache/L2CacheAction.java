package com.gemini.util.cache;

import java.util.List;

public class L2CacheAction<K, V> implements CacheAction<K, V> {

    public V doPust(List<Cache<K, V>> caches, K key, V value) {
        V prevValue = null;
        if (null != value) {
            prevValue = caches.get(1).put(key, value);
        }
        return prevValue;
    }

    public V doGet(List<Cache<K, V>> caches, K key) {
        V value = caches.get(0).get(key);
        if (null != value) {
            return value;
        } else {
            value = caches.get(1).get(key);
        }

        if (null != value) {
            caches.get(0).put(key, value);
            return value;
        } else {
            return null;
        }
    }

    public V doRemove(List<Cache<K, V>> caches, K key) {
        V value = null;
        for (Cache<K, V> c : caches) {
            V v = (V) c.remove(key);
            if (value == null) {
                value = v;
            }
        }
        return value;
    }

    public void doClear(List<Cache<K, V>> caches) {
        for (Cache<K, V> c : caches) {
            c.clear();
        }
    }

}
