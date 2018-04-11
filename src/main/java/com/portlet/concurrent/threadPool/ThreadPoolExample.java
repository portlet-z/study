package com.portlet.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: 张新征
 * @date: 2018/3/27 下午5:59
 */
@Slf4j
public class ThreadPoolExample {

    @Test
    public void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<10; i++){
            int index = i;
            executorService.execute(() -> {
                log.info("task:{}", index);
            });
        }

        executorService.shutdown();
    }

    @Test
    public void test2(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<10; i++){
            int index = i;
            executorService.execute(() -> {
                log.info("task:{}", index);
            });
        }
        executorService.shutdown();
    }


    @Test
    public void test3(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<10; i++){
            int index = i;
            executorService.execute(() -> {
                log.info("task:{}", index);
            });
        }
        executorService.shutdown();
    }

    @Test
    public void test4(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(() -> {
            log.warn("schedule run");
        }, 1, 3, TimeUnit.SECONDS);

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                log.warn("timer run");
//            }
//        }, new Date(), 5 * 1000);
    }
}
