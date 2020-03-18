package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class BinaryTreeInorderTraversal_94_2 {
    /**
     * 递归迭代
     *
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        helper(root, resList);
        return resList;
    }

    /**
     * 递归调用
     *
     * @param root
     * @param resList
     */
    private void helper(TreeNode root, List<Integer> resList) {
        // terminator condition
        if (root == null) {
            return;
        }

        if (root.left != null) {
            // drill down
            helper(root.left, resList);
        }
        resList.add(root.val);

        if (root.right != null) {
            // drill down
            helper(root.right, resList);
        }
    }

    /**
     * 基于栈的方式
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null && !stack.isEmpty()) {
            while (curr.left != null) {
                curr = curr.left;
            }
            // 出栈
            curr = stack.pop();
            resList.add(curr.val);
            curr = curr.right;
        }
        return resList;
    }

    /**
     * 莫里斯遍历
     *
     * @param root
     * @return
     */
    public List<Integer> solution3(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            if (curr.left == null) {
                resList.add(curr.val);
                curr = curr.right;
            } else {
                // 左节点有值
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                // 原位置置空
                temp.left = null;
            }

        }
        return resList;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal_94_2 coco = new BinaryTreeInorderTraversal_94_2();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;

        List<Integer> integers = coco.solution3(treeNode);
    }
}
