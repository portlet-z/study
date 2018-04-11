package com.portlet.concurrent.aps;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: 张新征
 * @date: 2018/3/27 下午5:50
 */
@Slf4j
public class CountDownLatchExample {

    private final static int threadCount = 200;

    @Test
    public void test1() throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i=0; i<threadCount; i++){
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(1000, TimeUnit.MICROSECONDS);
        log.info("finish");
        executorService.shutdown();
    }

    private void test(int threadNum) {
        try {
            Thread.sleep(100);
            log.info("{}", threadNum);
        }catch (Exception e){
            log.error("exception");
        }
    }
}
