package com.luckyboy.sun.leetCode.tree;

/**
 * TOOD
 *
 * @author Luckyboy
 * @version 1.0
 * @date 2022-2-16-0016 22:00:00
 */
public class BuildTreeTest {
    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode node = buildTree(inOrder, postOrder);
        System.out.println(node);
    }

    /**
     * 从中序和后序遍历找出这个树
     *
     * */
    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return bulid(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1);
    }

    private static TreeNode bulid(int[] inOrder, int inStart, int inEnd,
                                  int[] postOrder, int postStart, int postEnd) {
        if(inStart > inEnd) {
            return null;
        }
        //后序遍历最后一个就是根节点
        int rootVar = postOrder[postEnd];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inOrder[i] == rootVar) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVar);
        root.setLeft(bulid(inOrder, inStart, index - 1,
                postOrder, postStart, postStart + leftSize - 1));
        root.setRight(bulid(inOrder, index + 1, inEnd,
                postOrder, postStart + leftSize, postEnd - 1));
        return root;
    }
}
