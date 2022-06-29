package com.luckyboy.sun.leetCode.tree;

import sun.reflect.generics.tree.Tree;
import sun.rmi.server.InactiveGroupException;

import java.util.*;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-4-0004 22:31:39
 */
public class ConvertBSTTest {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(3);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2, null, node7);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7, null, node8);
        TreeNode node1 = new TreeNode(1, node3, node4);
        TreeNode node2 = new TreeNode(6, node5, node6);
        TreeNode root = new TreeNode(4, node1, node2);

        ConvertBSTTest convertBSTTest = new ConvertBSTTest();
        TreeNode node = convertBSTTest.convertBSTT(root);
        System.out.println(node);

    }

    private Set<Integer> set = new HashSet<>();
    public TreeNode convertBST(TreeNode root) {
        getList(root);
        convertBst(root);
        return root;
    }
    public void getList(TreeNode root) {
        if (root == null) {
            return;
        }
        getList(root.left);
        set.add(root.val);
        getList(root.right);
    }
    public void convertBst(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBst(root.left);
        int num = 0;
        for (Integer integer : set) {
            if (integer < root.val) {
                continue;
            }
            num = num + integer;
        }
        root.val = num;
        convertBst(root.right);
    }

    private int sum;
    public TreeNode convertBSTT(TreeNode root) {
        getListT(root);
        return root;
    }
    public void getListT(TreeNode root) {
        if (root == null) {
            return;
        }
        getListT(root.right);
        sum += root.val;
        root.val = sum;
        getListT(root.left);
    }

}
