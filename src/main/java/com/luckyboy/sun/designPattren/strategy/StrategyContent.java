package com.luckyboy.sun.designPattren.strategy;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-06-19 18:19
 **/
public class StrategyContent {
    private CustomerTagStrategy customerTagStrategy;

    public StrategyContent(CustomerTagStrategy customerTagStrategy) {
        this.customerTagStrategy = customerTagStrategy;
    }

    public CustomerTagStrategy getCustomerTagStrategy() {
        return customerTagStrategy;
    }

    public void setCustomerTagStrategy(CustomerTagStrategy customerTagStrategy) {
        this.customerTagStrategy = customerTagStrategy;
    }
}
