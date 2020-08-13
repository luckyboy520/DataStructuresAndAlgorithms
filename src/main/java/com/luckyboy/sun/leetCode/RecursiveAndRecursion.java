package com.luckyboy.sun.leetCode;

/**
 * 递归和递推的区别
 */

public class RecursiveAndRecursion {
    /**
     * 斐波那契数列：已知f(1) = 1 , f(2) = 1 , 且满足关系式f(n) = f(n-1) + f(n-2)
     */

    //递归算法
    public static int one(int n) {
        if (n == 1 || n == 2)
            return 1;
        return one(n - 1) + one(n - 2);
    }

    //递推算法---就是for循环
    public static int two(int n) {
        int[] b = new int[20];
        b[1] = 1;
        b[2] = 1;
        for (int i = 3; i <= n; i++) {
            b[i] = b[i - 1] + b[i - 2];
        }
        return b[n];
    }

    /**
     * 使用递归计算1+2+…+100 ；
     * 分析：递归关系为f(n) = f(n-1) + n ，递归出口为f(1) = 1 ;
     */

    public static int three(int n) {
        if (n == 1)
            return 1;
        return three(n - 1) + n;
    }

    public static int four(int n) {
        int[] a = new int[n + 1];
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + i;
        }
        return a[n];
    }

    public static void main(String[] args) {
//        System.out.println(one(5));
//        System.out.println(two(5));

        long start = System.currentTimeMillis();
//        System.out.println(three(30000));
        System.out.println("递归所需时间： " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        System.out.println(four(30000));
        System.out.println("动态规划保存中间值 ： " + (System.currentTimeMillis() - start2));
    }
}
