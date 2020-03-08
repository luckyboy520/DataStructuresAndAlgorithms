package com.luckyboy.sun.leetCode;

import java.util.ArrayList;
import java.util.List;

public class ConvertTwo {

    /***
     * 执行用时 :10 ms, 在所有 Java 提交中击败了52.69%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了7.13%的用户
     *
     * 1     5     9
     * 2  4  6  8
     * 3     7
     *
     * 1-4的总数是:2n-2
     * 2.按这个把字符串分成几个String的list
     * 用了String的charAt的方法
     */
    public String convert(String msg, int rowNums) {
        if(msg.equals(""))
            return "";
        if(msg.length() <= rowNums || rowNums == 1)
            return msg;
        StringBuilder builder = new StringBuilder();
        int j = 0;
        int k = 0;
        List<String> list = new ArrayList<>();
        int element = (2 * rowNums) -2;
        k = element;
        int index = (int)Math.ceil((double)msg.length()/(double)element);
        for(int i =0; i < index; i++) {
            if(i == index - 1)
                list.add(msg.substring(j, msg.length()));
            else {
                list.add(msg.substring(j, k));
            }
            j = j + element;
            k = k + element;
        }
        for(int i = 0; i < rowNums; i++) {
                for (String s : list) {
                    if(i == 0 || i == rowNums -1) {
                        if(i < s.length())
                            builder.append(s.charAt(i));
                    } else {
                        if (i < s.length()) {
                            builder.append(s.charAt(i));
                        }
                        if ((element-i) < s.length()) {
                            builder.append(s.charAt(element-i));
                        }
                    }
                }

        }
        return builder.toString();
    }
    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了48.42%的用户
     * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了6.81%的用户
     *
     * ******************************力扣上的解题思路，主要是flag = -flag
     * */
    public String convert2(String s, int numRows) {
        if(s.equals(""))
            return "";
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }


    public static void main(String[] args) {
        ConvertTwo convertTwo = new ConvertTwo();
/*        long start = System.currentTimeMillis();
        System.out.println(convertTwo.convert("PAYPALISHIRING", 3));
        System.out.println("convert one time is : " + (System.currentTimeMillis() - start));*/

        long start2 = System.currentTimeMillis();
        System.out.println(convertTwo.convert2("PAYPALISHIRING", 3));
        System.out.println("convert two time is : " + (System.currentTimeMillis() - start2));


    }
}
