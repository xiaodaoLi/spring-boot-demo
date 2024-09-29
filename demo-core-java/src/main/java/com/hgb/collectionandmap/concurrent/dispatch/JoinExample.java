package com.hgb.collectionandmap.concurrent.dispatch;

/**
 * 使用join方法让一个线程等待另一个线程执行完毕再执行
 *
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class JoinExample {
    public static void main(String[] args) {
        System.out.println("期待的执行顺序为Thread1 -》 Thread2 -》 Thread3");
        final Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": invoked");
        });
        thread1.setName("thread1");

        final Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": invoked");
        });
        thread2.setName("thread2");

        final Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": invoked");
        });

        thread3.setName("thread3");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
