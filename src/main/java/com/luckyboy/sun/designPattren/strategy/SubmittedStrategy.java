package com.luckyboy.sun.designPattren.strategy;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-06-19 18:18
 **/
public class SubmittedStrategy implements CustomerTagStrategy {
    @Override
    public void doSomeThing() {
        System.out.println("已成交");
    }
}
