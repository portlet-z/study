package com.portlet.concurrent.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author: 张新征
 * @date: 2018/4/10 下午3:43
 */
@Slf4j
public class HashMapTest {
    public static void main(String[] args) throws Exception{
        final HashMap<String, String> map = new HashMap<>();
        Thread t = new Thread(() -> {
            for (int i=0; i<10000; i++){
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                    log.info("{}", Thread.currentThread().getName());
                }, "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        t.join();
    }
}
