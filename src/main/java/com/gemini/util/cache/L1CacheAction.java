package com.gemini.util.cache;

import java.util.List;

public abstract class L1CacheAction<K, V> implements CacheAction<K, V> {
    public V doPust(List<Cache<K, V>> caches, K key, V value) {
        V v = null;
        v = caches.get(0).put(key, value);
        if (v != null) {
            return v;
        }
        return value;
    }

    public V doGet(List<Cache<K, V>> caches, K key) {
        return caches.get(0).get(key);
    }

    public V doRemove(List<Cache<K, V>> caches, K key) {
        return caches.get(0).remove(key);
    }

    public void doClear(List<Cache<K, V>> caches) {
        caches.get(0).clear();
    }
}
