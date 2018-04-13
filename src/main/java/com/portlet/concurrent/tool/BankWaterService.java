package com.portlet.concurrent.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: 张新征
 * @date: 2018/4/12 下午4:48
 */
@Slf4j
public class BankWaterService implements Runnable{

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> log.info("all finish"));

    /**
     * 假设只有4个sheet,所以只启动4个线程
     */
    private ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银行流水结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private void count(){
        for (int i=0; i<4; i++){
            int finalI = i;
            executor.execute(() -> {
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                log.info("parser{} finish", finalI);
            });
        }
        executor.shutdown();
    }

    @Override
    public void run() {
        log.info("all finish");
    }

    public static void main(String[] args){
        BankWaterService bank = new BankWaterService();
        bank.count();
    }
}
