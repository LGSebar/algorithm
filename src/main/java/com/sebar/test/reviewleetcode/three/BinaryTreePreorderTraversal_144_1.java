package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 144. 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal_144_1 {
    /**
     * 迭代递归
     * 前序遍历--根--》左--》右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTravelsal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        helper(resList, root);
        return resList;
    }

    /**
     * 递归调用
     *
     * @param resList
     * @param root
     */
    private void helper(List<Integer> resList, TreeNode root) {
        if (root != null) {
            return;
        }
        resList.add(root.val);
        if (root.left != null) {
            helper(resList, root.left);
        }
        if (root.right != null) {
            helper(resList, root.right);
        }
    }

    /**
     * 解决方法--栈
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            resList.add(currNode.val);

            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return resList;
    }


    public static void main(String[] args) {
        BinaryTreePreorderTraversal_144_1 coco = new BinaryTreePreorderTraversal_144_1();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        List<Integer> integers = coco.solution2(treeNode);
        System.out.println(integers);
    }
}
