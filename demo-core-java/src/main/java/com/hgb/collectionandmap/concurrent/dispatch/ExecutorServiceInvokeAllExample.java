package com.hgb.collectionandmap.concurrent.dispatch;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService invokeAll() 方法等待一组线程执行完毕
 *
 * @author huang.guangbing
 * @since 2024/9/17
 */
public class ExecutorServiceInvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> {
                //Thread.sleep(1000);
                System.out.println("Task-1");
                return "Task 1";
            },
            () -> {
                Thread.sleep(2000);
                System.out.println("Task-2");
                return "Task 2";
            },
            () -> {
                //Thread.sleep(1500);
                System.out.println("Task-3");
                return "Task 3";
            }
        );

        List<Future<String>> results = executor.invokeAll(tasks);

        System.out.println("------------");
        for (Future<String> result : results) {
            System.out.println("result: " + result.get());
        }
        System.out.println("------------");
        System.out.println("task1,2,3 is completed。");

        executor.shutdown();
    }
}
