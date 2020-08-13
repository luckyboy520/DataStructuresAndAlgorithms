package com.luckyboy.sun.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * <p>
 * **************************************
 * 使用到了stream流的list转数组技术
 * <p>
 * **************************************
 **/
public class SumOfTwo {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 5, 4};
        int target = 9;
        long start = System.currentTimeMillis();
        int[] ints = twoSum(nums, target);
        System.out.println("用时：" + (System.currentTimeMillis() - start));
        System.out.println(Arrays.toString(ints));

        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hahaha");
    }


    public static int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(i);
                    result.add(j);
                } else {
                    continue;
                }
                break;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
