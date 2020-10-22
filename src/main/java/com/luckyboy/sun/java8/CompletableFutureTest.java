package com.luckyboy.sun.java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-10-20 09:40
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() ->  {
            int i = 5;
            System.out.println(i);
            return i;
        })
        .thenApply(i -> i+1).whenComplete((i,t) -> System.out.println(i));
    }
}
