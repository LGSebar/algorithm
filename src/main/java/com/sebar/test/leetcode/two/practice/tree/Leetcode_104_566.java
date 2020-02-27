package com.sebar.test.leetcode.two.practice.tree;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/27
 * @Description
 */

public class Leetcode_104_566 {
    public int maxDepth(TreeNode root) {
        // terminator
        if (root == null) {
            return 0;
        }

        // drill down
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        // 逻辑处理
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
