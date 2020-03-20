package com.luckyboy.sun.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * */
public class CoinChange {
    private Integer m = 0;
    private Integer ji = 0;
    //记录当前相加值
    private Integer sum = 0;
    private List<Integer> integers = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length <= 0)
            return -1;
        if(coins.length == 1) {
            if(coins[0] == amount)
                return coins[0];
        }
        List<Integer> coinSet = new ArrayList();
        for(int i : coins) {
            coinSet.add(i);
        }
        //排序
        coinSet = coinSet.stream().sorted().collect(Collectors.toList());
        int length = coinSet.size();
        while(length > 0) {
            //获取现在集合最大值
            m = coinSet.get(length - 1);
            sum = getSum(sum, amount);
            //如果是-2，代表是成功的，直接返回相加次数
            if(sum == -2)
                return ji;
            length = length - 1;
        }
        return -1;
    }

    public Integer getSum(Integer max, int ammount) {
        if(max > ammount) {
            ji--;
            return max - m;
        }
        max += m;
        //代表ok
        if(max == ammount) {
            ji++;
            return -2;
        }
        ji++;
        return getSum(max, ammount);
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(fib(5));
        System.out.println(eval(5));
        System.out.println(getMax());
//        System.out.println(coinChange.coinChange(new int[]{1,2,5},11));

//        System.out.println(coinChange.coinChange(new int[]{186,419,83,408},6249));
    }

    public static int fib(int n) {
        if(n <= 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static double eval (int n) {
        if(n == 0)
            return 1.0;
        else {
            double sum = 0.0;
            for(int i =0; i < n;i++)
                sum += eval(i);
            return 2.0 * sum / n + n;
        }
    }

        public static int getMax(){
            int MAX = 10;
            int[][] D = new int[MAX][MAX];   //存储数字三角形
            int n =5;              //n表示层数
            int i = 0; int j = 0;
            int maxSum = getMaxSum(D,n,i,j);
            //如果输出一点东西都没有，因为是先赋值给二维数组，从二维数组求解
            for(int ii =0; ii< MAX; ii++) {
                for(int jj =0;jj< MAX;jj++) {
                    System.out.print(D[ii][jj] + " ");
                }
                System.out.println("");
            }
            return maxSum;
        }
        public static int getMaxSum(int[][] D,int n,int i,int j){
            if(i == n){
                return D[i][j];
            }
            int x = getMaxSum(D,n,i+1,j);
            int y = getMaxSum(D,n,i+1,j+1);
            return Math.max(x,y)+D[i][j];
        }


}
