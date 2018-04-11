package com.portlet.concurrent.lock;

import com.portlet.concurrent.basis.SleepUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author: 张新征
 * @date: 2018/4/6 下午5:20
 */
@Slf4j
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        log.info(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i=0; i<10; i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for(int i=0; i<10; i++){
            SleepUtils.second(1);
        }
    }
}
