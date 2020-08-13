package com.luckyboy.sun.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        longestPalindrome2("caba");
    }

    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        //记录字符串和它的长度
        Map<Integer, String> map = new HashMap<>(16);

        String[] split = s.split("");
        if (split.length == 1)
            return split[0];
        for (int i = 0; i < split.length; i++) {
            for (int j = i + 1; j < split.length; j++) {

                if (split[i].equals(split[j])) {
                    String substring = s.substring(i, j + 1);
                    boolean b = doThing(substring);
                    if (b) {
                        map.put(substring.length(), substring);
                    }
                }
                continue;
            }
        }
        if (map.size() > 0) {
            Integer integer = map.keySet().stream().max(Integer::compareTo).get();
            return map.get(integer);
        } else {
            return split[0];
        }
    }


    public static boolean doThing(String one) {
        boolean flag = false;
        String[] split = one.split("");
        int num = split.length / 2;

        for (int i = 0; i < num; i++) {
            if (split[i].equals(split[split.length - 1 - i])) {
                if (i == num - 1) {
                    flag = true;
                }
                continue;
            }
            return false;
        }
        return flag;
    }

    public static String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以 i 位置结尾的字符
                }

            }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
