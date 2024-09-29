package com.hgb.collectionandmap.concurrent.dispatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int numThreads = 3;
        final CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println(Thread.currentThread().getName() + ": 使用任意一个线程执行在cyclicBarrier内的逻辑");
            System.out.println(Thread.currentThread().getName() + ": All parties have arrived at the barrier");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < numThreads; i++) {
            final Thread thread = new Thread(task);
            thread.setName("thread-hgb-" + i);
            thread.start();
        }
    }
}
