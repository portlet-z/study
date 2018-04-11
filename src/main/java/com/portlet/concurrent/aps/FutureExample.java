package com.portlet.concurrent.aps;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author: 张新征
 * @date: 2018/3/27 下午7:54
 */
@Slf4j
public class FutureExample {

    class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception{
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    @Test
    public void test() throws Exception{
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in test");
        Thread.sleep(1000);
        log.info("result: {}", future.get());
        executorService.shutdown();
    }
}
