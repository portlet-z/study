package com.portlet.concurrent.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 张新征
 * @date: 2018/4/12 下午4:05
 */
@Slf4j
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException{
        new Thread(() -> {
            log.info("parser1 finish");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            log.info("parser2 finish");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        log.info("all parser finish");
    }
}
