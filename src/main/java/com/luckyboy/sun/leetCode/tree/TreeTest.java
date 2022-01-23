package com.luckyboy.sun.leetCode.tree;

/**
 * TOOD
 *
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

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        TreeNode connect = connect(node1);
        System.out.println(connect);

    }

    public static TreeNode connect(TreeNode node) {
        if(node.getLeft() == null) {
            return node;
        }
        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        left.setNext(right);

        connect(left);
        connect(right);
        return node;
    }
}
