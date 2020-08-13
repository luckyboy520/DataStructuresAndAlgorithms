package com.luckyboy.sun.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-08-03 11:57
 **/
public class ThreadSafeTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        new Thread(() -> {
            list.add(1);
            list.add(2);
            list.add(3);
        }).start();

        System.out.println(list.get(2));
    }

}
