package com.luckyboy.sun.concurrent;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-08-03 15:31
 **/
public class ForkJoinPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        for(int i=0; i< 10; i++) {
            ForkJoinTask<Integer> submit = forkJoinPool.submit(new test(i));
            System.out.println(submit.get());
        }
    }
}

class test extends RecursiveTask<Integer> {

    int n;

    public test(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n <= 1)
            return n;
        test test = new test(n -1);
        test.fork();
        test test1 = new test(n-2);
        test1.fork();
        return test.join() + test1.join();
    }
}
