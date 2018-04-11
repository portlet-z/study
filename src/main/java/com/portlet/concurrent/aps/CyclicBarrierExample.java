package com.portlet.concurrent.aps;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author: 张新征
 * @date: 2018/3/27 下午7:45
 */
@Slf4j
public class CyclicBarrierExample {

    private CyclicBarrier barrier = new CyclicBarrier(5);

    @Test
    public void test() throws Exception{
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("schedule-example-pool-%d").daemon(true).build());
        for(int i=0; i<10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                race(threadNum);
            });
        }
        executor.shutdown();
    }

    private void race(int threadNum){
        try {
            Thread.sleep(1000);
            log.info("{} is ready", threadNum);
            barrier.await();
            log.info("{} continue", threadNum);
        }catch (Exception e){

        }
    }
}
