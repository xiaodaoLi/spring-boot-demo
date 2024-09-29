package com.hgb.collectionandmap.concurrent.dispatch;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量Semaphore控制线程并发数量
 *
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class SemaphoreLimitCountExample {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired the semaphore");
                Thread.sleep(2000); // 模拟操作
                System.out.println(Thread.currentThread().getName() + " releasing the semaphore");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}
