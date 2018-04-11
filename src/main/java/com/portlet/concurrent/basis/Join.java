package com.portlet.concurrent.basis;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: 张新征
 * @date: 2018/4/3 下午1:57
 */
@Slf4j
public class Join {
    public static void main(String[] args) throws Exception{
        Thread previous = Thread.currentThread();
        for (int i=0; i<10; i++){
            //每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        log.info(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(Thread.currentThread().getName() + " terminate.");
        }
    }
}
