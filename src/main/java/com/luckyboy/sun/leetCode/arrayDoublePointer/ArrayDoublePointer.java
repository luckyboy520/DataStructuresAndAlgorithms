package com.luckyboy.sun.leetCode.arrayDoublePointer;

public class ArrayDoublePointer {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6}));
        System.out.println(removeDuplicates(new int[]{0, 0, 0, 1, 1, 1, 3, 4, 4, 5, 5, 5}));
        System.out.println(removeDuplicatesOne(new int[]{0, 0, 1, 1, 4, 4, 5}));
    }

    /**
     * 数组超过2个重复的就去掉，返回去掉后的是数组长度
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int index = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                if (index > 2) {
                    index = 2;
                }
                slow = slow + index;
                nums[slow] = nums[fast];
                index = 1;
            } else {
                index++;
            }
            fast++;
            if (fast == nums.length) {
                if (index > 2) {
                    index = 2;
                }
                slow = slow + index;
            }
        }
        return slow;
    }

    /**
     * 找出不重复的数组，把重复的去掉然后返回数组长度
     * */
    public static int removeDuplicatesOne(int[] nums) {
        int slow = 0; int fast = 0;
        while (fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
