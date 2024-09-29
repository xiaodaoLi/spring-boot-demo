package com.hgb.collectionandmap.concurrent.dispatch;

import java.util.concurrent.CountDownLatch;

/**
 * 使用countDownLatch控制执行顺序，等待一组线程执行完毕之后才执行某个线程
 *
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class CountDownLatchExample {
    public static void main(String[] args) {
        System.out.println("期待执行顺序为：线程1,2,3 均执行完毕后再执行线程4");

        final CountDownLatch countDownLatch = new CountDownLatch(3);
        final Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": invoked");
            countDownLatch.countDown();
        });
        thread1.setName("thread1");

        final Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": invoked");
            countDownLatch.countDown();
        });
        thread2.setName("thread2");

        final Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": invoked");
            countDownLatch.countDown();

        });
        thread3.setName("thread3");

        final Thread thread4 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=========================");
            System.out.println(Thread.currentThread().getName() + ": invoked");
        });
        thread4.setName("thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
