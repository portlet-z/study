package com.portlet.concurrent.basis;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/3 上午9:52
 */
@Slf4j
public class Daemon {
    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                log.info("DaemonThread finally run.");
            }
        }
    }
}
