package com.hgb.collectionandmap.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的几种方式
 *
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class CreateThread {
    public static void main(String[] args) throws Exception {

        newThread();

        runnableThread();

        callableThread();

    }

    private static void callableThread() throws Exception {
        final Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : new a callable");
                return "aaaa";
            }
        };

        final FutureTask<String> stringFutureTask = new FutureTask<>(stringCallable);
        new Thread(stringFutureTask).start();
        final String callableResult = stringFutureTask.get();
        System.out.println(Thread.currentThread().getName() + ": the result of callable is " + callableResult);
    }

    /**
     * 使用Runnable创建线程
     */
    private static void runnableThread() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : new a runnable");
            }
        };
        final Thread runnableThread = new Thread(runnable);
        runnableThread.setName("runnableThread");
        runnableThread.start();
    }

    /**
     * 使用new Thread 直接创建线程
     */
    private static void newThread() {
        final Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : new a thread");
        });
        thread.setName("thread-1");
        thread.start();
    }
}
