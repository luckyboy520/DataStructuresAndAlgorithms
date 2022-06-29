package com.luckyboy.sun.leetCode.tree;

import com.google.inject.internal.cglib.core.$LocalVariablesSorter;

import java.util.*;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-2-0002 22:08:47
 */
public class kthSmallestTest {
    private static int index;
    private static int num;

    public static int kthSmallest(TreeNode root, int k) {
        find(root,k);
        return num;
    }


    public  static void find(TreeNode root,int k) {
        if (root == null || index == k) {
            return;
        }
        find(root.left,k);
        index++;
        if(index == k) {
            num = root.val;
            return;
        }
        find(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        n1.setRight(n3);
        TreeNode n = new TreeNode(3, n1,n2);
        int i = kthSmallest(n, 4);
        System.out.println(i);
    }
    public static void sort(TreeNode e) {
        if(e == null) return;
        sort(e.left);
        System.out.println(e.val);
        sort(e.right);
    }
}
