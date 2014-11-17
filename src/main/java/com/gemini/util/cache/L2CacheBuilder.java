package com.gemini.util.cache;

import java.util.UUID;

public class L2CacheBuilder<K, V> {

    private int mMaxMemorySize = -1;
    private long mExpireTime = -1;
    private long mMaxDiskSize = -1;
    private String mPath;
    private String mCacheName;

    public L2CacheBuilder(String mCacheName) {
        this.mCacheName = mCacheName;
    }

    public L2CacheBuilder<K, V> setMaxMemorySize(int maxMemorySize) {
        this.mMaxMemorySize = maxMemorySize;
        return this;
    }

    public L2CacheBuilder<K, V> setExpireTime(int expireTime) {
        this.mExpireTime = expireTime;
        return this;
    }

    public L2CacheBuilder<K, V> setMaxDiskSize(int maxDiskSize) {
        this.mMaxDiskSize = maxDiskSize;
        return this;
    }

    public L2CacheBuilder<K, V> setPath(String path) {
        this.mPath = path;
        return this;
    }

    public Cache<K, V> build() {
        if (-1 == this.mMaxMemorySize || -1 == this.mExpireTime
                || -1 == this.mMaxDiskSize || null == this.mCacheName
                || null == this.mPath) {
            throw new IllegalStateException(
                    "must be assigned memMaxSize, maxDiskSize, dirExpireTime, diskPath, cacheName");
        }
        L2Cache<K, V> cache = new L2Cache<K, V>();
        cache.setL1Cache(new MemoryCache<K, V>(UUID.randomUUID().toString()));
        FileCache<K, V> fileCache = new FileCache<K, V>(UUID.randomUUID()
                .toString(), this.mPath);
        if (this.mExpireTime != -1) {
            fileCache.setExpireTime(this.mExpireTime);
        }
        if (this.mMaxDiskSize != -1) {
            fileCache.setMaxDiskSize(this.mMaxDiskSize);
        }
        cache.setL2Cache(fileCache);
        cache.setL2cacheAction(new L2CacheAction<K, V>());
        return cache;
    }

}
