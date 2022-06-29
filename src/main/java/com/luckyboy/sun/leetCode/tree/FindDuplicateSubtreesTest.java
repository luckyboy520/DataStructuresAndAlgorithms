package com.luckyboy.sun.leetCode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-3-1-0001 23:11:24
 */
public class FindDuplicateSubtreesTest {
    //记录重复的数据
    private static HashMap<String ,Integer> map = new HashMap<>();
    //保存每次遍历的结果
    private static List<TreeNode> list = new ArrayList();
//    private TreeNode

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return list;
    }

    public static String find(TreeNode node) {
        if(node == null) {
            return "#";
        }
        String left = find(node.left);
        String right = find(node.right);

        String re = left + "," + right +"," + node.val;
        Integer orDefault = map.getOrDefault(re, 0);
        if(orDefault == 1) {
            list.add(node);
        }
        map.put(re, orDefault + 1);
        return re;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);

        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);node1.setRight(node4);
        node2.setLeft(node5);
        System.out.println(traverse(node));

        System.out.println(findDuplicateSubtrees(node));
    }
    static String traverse(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traverse(root.getLeft());
        String right = traverse(root.getRight());
        /* 后序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.getVal();
        return subTree;
    }

}