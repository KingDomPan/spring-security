package com.gemini.util.cache;

import java.util.List;

public interface CacheAction<K, V> {
    V doPust(List<Cache<K, V>> caches, K key, V value);

    V doGet(List<Cache<K, V>> caches, K key);

    V doRemove(List<Cache<K, V>> caches, K key);

    void doClear(List<Cache<K, V>> caches);
}
