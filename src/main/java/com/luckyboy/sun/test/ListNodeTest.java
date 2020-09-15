package com.luckyboy.sun.test;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-09-14 15:29
 **/
public class ListNodeTest {

    public static void main(String[] args) throws NoSuchMethodException {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        Predicate<String> predicate = (s) -> s.length() >0;
        System.out.println(predicate.test("111"));

/*        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(node1.toString());

        //翻转链表
        ListNode listNode = flipNodeG(node1);
        System.out.println("翻转结果：" + listNode.toString());*/
    }



    /**
     * 单链表的翻转
     * @param node
     * @return: com.atguigu.linkedlist.ListNode
     * @Author: LuckyBoy
     * @date: 2020-09-14 15:57
     */
    public static ListNode flipNode (ListNode node) {
        ListNode next = null;
        while (node.next != null) {
            ListNode t = new ListNode(node.value);
            ListNode n = new ListNode(node.next.value);
            if(next != null) {
                n.next = next;
                next = n;
            } else {
                next = n;
                n.next = t;
            }
            node = node.next;
        }
        return next;
    }

    /**
     * 翻转链表最优解
     * @param node
     * @return: com.atguigu.linkedlist.ListNode
     * @Author: LuckyBoy
     * @date: 2020-09-14 16:59
     */
    public static ListNode flipNodeG(ListNode node) {
        ListNode next;
        ListNode pre = null;
        while (node != null) {
            next = node.next;
            //让上一个节点指向下一个节点
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}


class ListNode {
    Integer value;
    ListNode next;

    public ListNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode listNode = this;
        while (listNode.next != null) {
            s.append(listNode.value).append("->");
            listNode = listNode.next;
        }
        s.append(listNode.value);
        return s.toString();
    }

}
