package com.portlet.concurrent.tool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/12 下午3:55
 */
@Slf4j
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException{
        Thread parser1 = new Thread(() -> {
            log.info("parser1 finish");
        });
        Thread parser2 = new Thread(() -> {
            log.info("parser2 finish");
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser1.join();
        log.info("all parser finish");
    }
}
