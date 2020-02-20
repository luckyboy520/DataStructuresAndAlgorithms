package com.luckyboy.sun.leetCode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


  思路：使用hashset，遍历的时候添加进hashset，添加成功就一直计数，如果遇到重复的，则从这个数开始在往下遍历
  技术使用：使用了List.subList方法和指定跳转
 * */

public class NoRepeatString {
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        //记录每个不重复的长度
        List<Integer> lengths = new ArrayList<>();
        List<String> noRepeat = new ArrayList();
        String[] split = s.split("");
        List<String> strings = Arrays.asList(split);

        boolean flag = true;
        outer:
        while (flag) {
            for(int i = 0; i < strings.size(); i++) {
                if(!noRepeat.contains(strings.get(i))) {
                    noRepeat.add(strings.get(i));
                }else {
                    lengths.add(noRepeat.size());
                    if(i == strings.size() - 1) {
                        flag = false;
                        break outer;
                    }
                    strings = strings.subList(noRepeat.indexOf(strings.get(i)) + 1, strings.size());
                    //清空记录
                    noRepeat.clear();
                    continue outer;
                }
                if(i == strings.size() -1) {
                    lengths.add(noRepeat.size());
                }
            }
            flag = false;
        }
        Optional<Integer> max = lengths.stream().max(Integer::compareTo);
        return max.get();
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        List<Integer> integers = ints.subList(2, ints.size());
        System.out.println(integers);
        int abcabcbb = lengthOfLongestSubstring("abderqwcxvbncabcbb");
        System.out.println(abcabcbb);

    }
}
