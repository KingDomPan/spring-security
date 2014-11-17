package com.gemini.util.cache;

import org.apache.commons.collections.map.LRUMap;

public class MemoryCache<K, V> implements Cache<K, V> {

    private String mIdentifier;
    private static final int DEFAULT_MAX_MEMORY_SIZE = 200;
    private LRUMap lruMap = null;

    public String getIdentifier() {
        return mIdentifier;
    }

    public MemoryCache(String identifier) {
        this.lruMap = new LRUMap(MemoryCache.DEFAULT_MAX_MEMORY_SIZE);
        this.mIdentifier = identifier;
    }

    public MemoryCache(String identifier, int maxMemorySize) {
        this.lruMap = new LRUMap(maxMemorySize);
        this.mIdentifier = identifier;
    }

    public void clear() {
        this.lruMap.clear();
    }

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        return (V) this.lruMap.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        return (V) this.lruMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public V remove(K key) {
        return (V) this.lruMap.remove(key);
    }

    public int size() {
        return this.lruMap.size();
    }

}
