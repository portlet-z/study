package com.portlet.concurrent.basis;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: 张新征
 * @date: 2018/4/3 下午2:04
 */
@Slf4j
public class Profiler {
    /**
     * 第一次get()方法调用时会进行初始化(如果set方法没有调用),每个线程会调用一次
     */
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        log.info("Cost: {} mills", Profiler.end());
    }
}
