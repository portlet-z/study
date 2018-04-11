package com.portlet.concurrent.basis;

import java.util.concurrent.TimeUnit;

/**
 * @author: 张新征
 * @date: 2018/4/3 上午9:34
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
