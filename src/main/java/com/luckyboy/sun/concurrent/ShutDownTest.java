package com.luckyboy.sun.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-08-03 16:42
 **/
public class ShutDownTest {
    private static int a = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            ShutDownTest.a = 5;
            System.out.println("-----------------------");
        });

        List<Runnable> runnables = executorService.shutdownNow();
        runnables.forEach(runnable -> {
            System.out.println(runnable.toString());
        });
        Thread.sleep(2000);
        System.out.println(a);


    }
}
