package com.portlet.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: 张新征
 * @date: 2018/4/8 下午4:53
 */
public class Cache {

    private static final Map<String, Object> map = new HashMap<>();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock read = rwl.readLock();
    private static final Lock write = rwl.writeLock();

    public static final Object get(String key){
        read.lock();
        try{
            return map.get(key);
        }finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object value){
        write.lock();
        try {
            return map.put(key, value);
        }finally {
            write.unlock();
        }
    }

    public static final void clear(){
        write.lock();
        try {
            map.clear();
        }finally {
            write.unlock();
        }
    }
}
