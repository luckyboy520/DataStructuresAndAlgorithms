package com.luckyboy.sun.leetCode.tree;

/**
 * TODO 力扣第116题
 * 给定一个完美二叉树（就是所有父节点都有两个子节点）
 * 填充它的next指针，让这个指针都指向同层的右侧节点，如果找不到右侧节点，则next设置为空，初始状态下，所有next都设置为空
 * @author Luckyboy
 * @version 1.0
 * @date 2022-1-23-0023 17:36:50
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);


        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);

        node5.setLeft(node10);
        node5.setRight(node11);

        node6.setLeft(node12);
        node6.setRight(node13);

        node7.setLeft(node14);
        node7.setRight(node15);



        TreeNode connect = connect(node1);
        System.out.println(connect);

    }

    public static TreeNode connect(TreeNode node) {
        //判断node的right和或者left不为空即可
        if(node.getLeft() == null) {
            return node;
        }
        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        //先把节点内的next搞定
        left.setNext(right);
        //对于跨节点的，根据当前节点的父节点的next（如果next存在的话）,就能找到他的跨节点
        TreeNode next = node.getNext();
        if(next != null) {
            right.setNext(next.getLeft());
        }
        connect(left);
        connect(right);
        return node;
    }
}

class TreeNode {
    private Integer val;
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }
}

