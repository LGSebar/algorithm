package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal_94_1 {

    /**
     * 中序遍历
     * 左--》根--》右
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        helper(resList, root);
        return resList;
    }

    /**
     * 递归--dfs
     *
     * @param resList
     * @param root
     */
    private void helper(List<Integer> resList, TreeNode root) {
        // terminator condition
        if (root == null) {
            return;
        }
        if (root.left != null) {
            // drill down
            helper(resList, root.left);
        }
        resList.add(root.val);
        if (root.right != null) {
            // drill down
            helper(resList, root.right);
        }
    }

    /**
     * 基于栈的方式，栈先进后出
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null && !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //左边入栈完成后，出栈
            curr = stack.pop();
            resList.add(curr.val);
            curr = curr.right;
        }
        return resList;
    }

    /**
     * 莫里斯
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
                //原位置的left置空
                temp.left = null;
            }
        }
        return resList;
    }
}
