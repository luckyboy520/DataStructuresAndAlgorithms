package com.luckyboy.sun.designPattren.strategy;

/**
 * @description: 未接听实现
 * @author: LuckyBoy
 * @create: 2020-06-19 09:56
 **/
public class MissedStrategy implements CustomerTagStrategy {
    @Override
    public void doSomeThing() {
        System.out.println("未接听");
    }
}
