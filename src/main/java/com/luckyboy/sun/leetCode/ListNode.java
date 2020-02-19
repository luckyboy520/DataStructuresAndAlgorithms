package com.luckyboy.sun.leetCode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger l1Num = reverse(l1);
        BigInteger l2Num = reverse(l2);
        BigInteger add = l1Num.add(l2Num);
        StringBuffer sum = new StringBuffer();
        sum.append(add.toString());
        return StringToNode(sum);
    }

    public static BigInteger reverse(ListNode ll) {
        StringBuffer num = new StringBuffer();
        while (ll.next != null) {
            num.append(ll.val);
            ll = ll.next;
        }
        num.append(ll.val);
        //这里的字符串反转使用到了stringBuffer的reverse方法能直接反转
        num.reverse();

        /**
         * 在这里如果用Long.valueOf或者Integer.valueOf的话是不行的，因为如果数字过长则会报错
         * 所以想到用支持很长数字的类型BigInteger
         * */
        return new BigInteger(num.toString());
    }

    public static ListNode StringToNode(StringBuffer sum) {
        //反转
        sum.reverse();
        /**
         * 一开始拆分以为不能已空字符串做拆分，经过试验结果是可行的
         * */
        String[] split = sum.toString().split("");
        ListNode node = new ListNode(Integer.valueOf(split[0]));
        /**
         * 这个方法的关键还是这里，如果把每一个数字按照单链表的形式连接起来
         * 在这里主要是定义一个辅助节点
         * 当第一次进去循环的时候，直接把当前节点的next指定新节点即可，然后把新节点指定给辅助节点
         * 那么下一次循环就会从这个辅助节点开始赋值，原来的node节点是不会改变的，因为node的next就是辅助节点
         * **/
        //定义一个辅助节点
        ListNode fuzhu = null;
        for(int i =1; i< split.length;i++) {
            ListNode node1 = new ListNode(Integer.valueOf(split[i]));
            if(i ==1) {
                node.next = node1;
            } else {
                fuzhu.next = node1;
            }
            fuzhu = node1;

        }
        return node;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        ListNode node4 =  new ListNode(7);
        node3.next = node4;

        ListNode node5 = addTwoNumbers(node1, node3);
        System.out.println(reverse(node1));

        String one = "1234";
        System.out.println(one.split("")[0]);

        StringBuffer stringBuffer = new StringBuffer("1234");

        ListNode node = StringToNode(stringBuffer);
        System.out.println(node);

        BigInteger bi1 = new BigInteger("999");
        BigInteger bi2 = new BigInteger("50");

        //public BigInteger add(BigInteger val):加
        System.out.println("add:"+bi1.add(bi2));

    }
}