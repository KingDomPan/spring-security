package com.gemini.util.cache;

import java.util.ArrayList;
import java.util.List;

public class L2Cache<K, V> implements Cache<K, V> {

    private CacheAction<K, V> l2cacheAction;

    private List<Cache<K, V>> caches = new ArrayList<Cache<K, V>>(2);

    public void setL2cacheAction(CacheAction<K, V> l2cacheAction) {
        if (!(l2cacheAction instanceof L2CacheAction<?, ?>)) {
            throw new IllegalArgumentException(
                    "This Cache Action Must Be Level 2");
        }
        this.l2cacheAction = l2cacheAction;
    }

    public void setL1Cache(Cache<K, V> memoryCache) {
        this.caches.add(0, memoryCache);
    }

    public void setL2Cache(Cache<K, V> fileCache) {
        this.caches.add(1, fileCache);
    }

    public Cache<K, V> getL1Cache() {
        Cache<K, V> c = null;
        try {
            c = this.caches.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("L1 Cache IS Null");
        }
        return c;
    }

    public Cache<K, V> getL2Cache() {
        Cache<K, V> c = null;
        try {
            c = this.caches.get(1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("L2 Cache IS Null");
        }
        return c;
    }

    public V put(K key, V value) {
        checkActionNotNull();
        return this.l2cacheAction.doPust(caches, key, value);
    }

    public V get(K key) {
        checkActionNotNull();
        return this.l2cacheAction.doGet(caches, key);
    }

    public V remove(K key) {
        checkActionNotNull();
        return this.l2cacheAction.doRemove(caches, key);
    }

    public void clear() {
        checkActionNotNull();
        this.l2cacheAction.doClear(caches);
    }

    private void checkActionNotNull() {
        if (null == l2cacheAction) {
            throw new IllegalStateException("No Level 2 Cache Action");
        }
    }

}
