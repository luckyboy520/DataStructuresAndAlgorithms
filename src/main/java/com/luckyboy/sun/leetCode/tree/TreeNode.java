package com.luckyboy.sun.leetCode.tree;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-1-23-0023 17:35:26
 */
public class TreeNode {
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
