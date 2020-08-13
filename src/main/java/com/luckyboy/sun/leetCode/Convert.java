package com.luckyboy.sun.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * LCIRETOESIIGEDHN
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * LDREOEIECIHTSG
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class Convert {
    private StringBuilder stringBuffer = new StringBuilder();
    private int index = 0;

    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.convert("pau", 4));
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");

    }

    /***
     * 执行用时 :10 ms, 在所有 Java 提交中击败了25.41%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了5.96%的用户
     */
    public String convert(String msg, int num) {
        if (msg.equals(""))
            return "";
        if (msg.length() <= num || num == 1)
            return msg;
        //拆分的元素和迭代
        int element = (2 * num) - 2;
        index = element;

        String[] split = msg.split("");

        for (int i = 0; i < num; i++) {
            if (i == 0 || i == num - 1) {
                getFirst(split, i);
                continue;
            }
            getMiddle(split, i, index - i);
        }
        return stringBuffer.toString();
    }

    public StringBuilder getFirst(String[] split, int element) {
        if (element >= split.length)
            return stringBuffer;
        stringBuffer.append(split[element]);
        return getFirst(split, element + index);
    }

    public StringBuilder getMiddle(String[] split, int start, int end) {
        if (start >= split.length)
            return stringBuffer;
        stringBuffer.append(split[start]);
        if (end < split.length)
            stringBuffer.append(split[end]);

        return getMiddle(split, start + index, end + index);
    }
}
