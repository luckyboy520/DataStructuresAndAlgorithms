package com.luckyboy.sun.leetCode;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2021-8-28-0028 15:50:53
 */
public class ListNodeTest {
    //TODO 建议最好还是不要用递归，因为递归的空间复杂度是o(n)，时间复杂度是o(1)
    //TODO 还是用迭代吧，用时间换空间好一点，毕竟内存是有限的，但是时间嘛有时候也是可以等的嘛
    private static ListNode successNext = null;

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

//        System.out.println(reverseN(a, 4));
        System.out.println(reverseK(a, 3));
    }

    /**
     * 反转前m个节点   思路是看下反转之后的指针赋值
     * @param head
     * @param m
     * @return
     */
    public static ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            successNext = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successNext;
        return last;
    }

    /**
     * 反转链表区间，其实老实说这个想了很久，没必要，从哪个m开始就往后走多少次嘛，就是m-1最后等于1就行了，最后再使用上面的反转
     * m个节点
     * @param head
     * @param n
     * @param m
     * @return
     */
    public static ListNode reverseMN(ListNode head, int m, int n ) {
        if(m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseMN(head.next, m-1 ,n- 1);
        return head;
    }

    public static ListNode reverseK(ListNode head, int k) {
        ListNode nnext = head;

        while (nnext.next != null) {
            int index = 1;
            ListNode cur = head;
            ListNode pre;
            while (cur.next != null && index <= k) {
                if (index == k) {
                    nnext = cur.next;
                    cur.next = null;
                    continue;
                }
                cur = cur.next;
                index++;
            }
            ListNode reverse = reverse(head);
            pre = reverse;
        }
        return null;
    }

    public static ListNode reverse(ListNode node) {
        ListNode pre = null,next;
        ListNode cur = node;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
