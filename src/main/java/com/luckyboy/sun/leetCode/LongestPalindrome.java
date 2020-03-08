package com.luckyboy.sun.leetCode;

import java.util.*;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 回文串的意思就是正读和反读一样的字符串
 * 例如： baab
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * ArrayList有两个，需要复制时，不能直接用等于，会公用同一个地址，要使用allAll方法
 *
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * 主要思路：使用lastindexof方法找到前后相同的元素，现找到最后一个，不匹配把最后一个去掉再重新找，找到则直接跳出当前循环
 * 每一个元素都要这样。
 * 主要使用技术:StringBuffer的反转方法和string的lastindexOf方法
 *
 */
public class LongestPalindrome {
    private static int ie = 0;
    /**
     * 有几种情况是直接返回的
     * 1.当长度为1时，直接返回改字符串
     * 2.当字符串每一个相同字符时，是默认返回第一个
     * */
    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        //记录字符串和它的长度
        Map<Integer, String> map = new HashMap<>(16);
        List<String> strings = new ArrayList<>();

        String[] split = s.split("");
        if (split.length == 1)
            return split[0];
        for (String ss : split) {
            strings.add(ss);
        }
        for (int i = 0; i < strings.size(); i++) {
            String item = strings.get(i);
            List<String> strings1 = new ArrayList<>();
            strings1.addAll(strings);
            //这里用到了while，是因为要不停去执行，直到那个list大小为空或者成功匹配到则跳过当前去执行下一次循环

            while (strings1.size() > 0) {
                int i1 = strings1.lastIndexOf(item);
                if (i1 != -1 && i1 !=0 && (i1 > i)) {
                    String substring = s.substring(i, i1 + 1);
                    boolean b = doThing(substring);
                    if (b) {
                        map.put(substring.length(), substring);
                        strings1.clear();
                    } else {
                        strings1 = strings1.subList(0, i1);
                    }
                } else {
                    strings1.clear();
                }
            }
            continue;
        }
        if (map.size() > 0) {
            Integer integer = map.keySet().stream().max(Integer::compareTo).get();
            return map.get(integer);
        } else {
            return split[0];
        }
    }
    /**
     * 方案一：是遍历这个string，对比前和后的字符串是否一一相等，总体耗时达到了500ms左右，提交到力扣的时候提示超过时间限制了
     * */
/*
    public static boolean doThing(String one) {
        boolean flag = false;
        String[] split = one.split("");
        int num = split.length / 2;

        for (int i = 0; i < num; i++) {
            if (split[i].equals(split[split.length - 1-i])) {
                if (i == num - 1) {
                    flag = true;
                }
                continue;
            }
            return false;
        }
        return flag;
    }
*/
    /**
     * 方案二：这个方案的思路是基于StringBuffer的反转方法的，二分法把字符串拆开，把另一半反转再和那个比较，相等则成功，耗时是100ms左右，通过了力扣的测试
     * */
    public static boolean doThing(String one) {
        int length = one.length();
        int numa = 0;
        if(length % 2 == 0 ) {
            numa = length / 2;
        } else {
            numa = (length / 2) + 1;
        }

        String firstHalf = one.substring(0, length / 2);
        String lastHalf = one.substring(numa, length);

        String s = new StringBuffer(lastHalf).reverse().toString();
        if(firstHalf.equals(s)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(doThing("abbas"));
        long l = System.currentTimeMillis();
        System.out.println(longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"));
        System.out.println("所需要时间：" + (System.currentTimeMillis() - l));
    }
}
