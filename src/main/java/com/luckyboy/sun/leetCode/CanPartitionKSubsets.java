package com.luckyboy.sun.leetCode;

import java.util.ArrayList;
import java.util.List;

public class CanPartitionKSubsets {
    private static int sumE = 0;
    private static int[] numss;
    private static List list = new ArrayList();

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        numss = nums;
        //计算数组总和
        int sum = 0;
        for(int s : nums) {
            sum += s;
        }

        //过滤已经计算的集合
        List<Integer> list = new ArrayList();
        //每一个sum的总和
        sumE = sum / k;
        //最后结果
        int last = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == sumE && !list.contains(i)) {
                last++;
                list.add(i);
                continue;
            }
            for(int j = i+1; j < nums.length; j++) {
                if((nums[i] + nums[j] == sumE) && !list.contains(i) && !list.contains(j)) {
                    last++;
                    list.add(i);list.add(j);
                    break;
                }
            }
        }

        if(k == last)
            return true;
        return false;
    }

    public static boolean sum (int sum,int a) {
        if(sum > sumE || a > numss.length -1) {
            return false;
        }
        if(sum == sumE) {
            
        }
        sum += a;
        return sum(sum, a+1);
    };

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6},3));
    }
}
