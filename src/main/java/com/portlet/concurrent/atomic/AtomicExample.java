package com.portlet.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 张新征
 * @date: 2018/3/27 下午7:33
 */
@Slf4j
public class AtomicExample {

    /**
     * 请求总数
     */
    private int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    private int threadTotal = 200;

    private AtomicInteger count = new AtomicInteger(0);

    @Test
    public void test() throws Exception{
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
                new BasicThreadFactory.Builder().namingPattern("schedule-example-pool-%d").daemon(true).build());
//        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0; i<clientTotal; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count: {}", count.get());
    }

    private void add(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        log.info("count: {}", count.incrementAndGet());
    }
}
