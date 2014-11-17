package com.gemini.util.cache;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileCache<K, V> implements Cache<K, V> {

    private Logger logger = Logger.getLogger(FileCache.class.getName());
    private static long DEFAULT_MAX_DISK_SIZE = 10 * 1024 * 1024;
    private static long DEFAULT_MAX_EXPIRED_TIME = 3 * 24 * 60 * 60 * 1000;
    private String mIdentifier;
    private File mDisk;
    @SuppressWarnings("unused")
    private String mPath;
    private long mExpireTime = DEFAULT_MAX_EXPIRED_TIME;
    private long mMaxDiskSize = DEFAULT_MAX_DISK_SIZE;

    public FileCache(String identifier, String path) {
        this.mIdentifier = identifier;
        this.mPath = path;
        this.mDisk = new File(path, this.mIdentifier);
    }

    public long getExpireTime() {
        return mExpireTime;
    }

    public void setExpireTime(long mExpireTime) {
        this.mExpireTime = mExpireTime;
    }

    public long getMaxDiskSize() {
        return mMaxDiskSize;
    }

    public void setMaxDiskSize(long mMaxDiskSize) {
        this.mMaxDiskSize = mMaxDiskSize;
    }

    public V put(K key, V value) {
        checkDirHasCreate();
        if (this.isDirOutOfMaxSpace()) {
            this.clear();
        }
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        File file = new File(mDisk, String.valueOf(key));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        checkDirHasCreate();
        V value = null;
        if (isFileExpired(String.valueOf(key))) {
            remove(key);
            return null;
        }
        File file = new File(this.mDisk, String.valueOf(key));
        if (!file.exists()) {
            return null;
        }
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            value = (V) ois.readObject();
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        checkDirHasCreate();
        File file = new File(this.mDisk, String.valueOf(key));
        if (file.exists()) {
            file.delete();
        }
        return null;
    }

    public void clear() {
        try {
            FileUtils.deleteDirectory(this.mDisk);
        } catch (IOException e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
    }

    private void checkDirHasCreate() {
        if (!this.mDisk.exists()) {
            this.mDisk.mkdirs();
        }
    }

    private boolean isFileExpired(String filename) {
        File file = new File(this.mDisk, filename);
        if (!file.exists()) {
            return false;
        }
        return (System.currentTimeMillis() - file.lastModified()) > this.mExpireTime;
    }

    private boolean isDirOutOfMaxSpace() {
        return FileUtils.sizeOfDirectory(this.mDisk) > this.mMaxDiskSize;
    }

}
