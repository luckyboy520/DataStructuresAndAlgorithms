package com.luckyboy.sun.test;

import java.util.List;
import java.util.Objects;
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
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(node1.toString());

/*        //翻转链表
        ListNode listNode = flipNodeG(node1);
        System.out.println("翻转结果：" + listNode.toString());*/

        System.out.println(daoshuk(node1,4));
        System.out.println(daoshuz(node1,4));

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
            //让上一个节点指向该节点的下一个节点
            node.next = pre;
            //吧这个节点赋值给pre
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 链表倒数第k个节点--》就是length-k个节点
     * @param k
     * @return: java.lang.String
     * @Author: LuckyBoy
     * @date: 2020-09-16 14:04
     */
    public static Integer  daoshuk(ListNode listNode, Integer k) {
        if(listNode == null)
            return -1;
        ListNode fuzhu = listNode;
        int length = 1;
        while (fuzhu.next != null) {
            length++;
            fuzhu = fuzhu.next;
        }
        if(k > length)
            return -1;

        for(int i=0;i<length-k;i++) {
            listNode = listNode.next;
        }
        return Objects.requireNonNull(listNode).getValue();
    }


    /**
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
     * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
     * @param head
     * @param k
     * @return: java.lang.Integer
     * @Author: LuckyBoy
     * @date: 2020-09-16 14:38
     */
    public static Integer daoshuz(ListNode head, Integer k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q.getValue();
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
