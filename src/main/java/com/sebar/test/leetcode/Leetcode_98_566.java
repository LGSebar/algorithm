package com.sebar.test.leetcode;

/*
 *验证是不是二叉树
 */
public class Leetcode_98_566 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return recursiveValid(root, null, null);
    }

    /**
     * 递归验证是不是完全二叉树
     *
     * @param root
     * @return
     */
    private Boolean recursiveValid(TreeNode root, Integer lower, Integer bigger) {
        // terminator
        if (root == null) {
            return true;
        }

        // process logic
        int currentNodeVal = root.val;

        if (lower != null && lower >= currentNodeVal) {
            return false;
        }
        if (bigger != null && bigger <= currentNodeVal) {
            return false;
        }

        if (!recursiveValid(root.left, lower, currentNodeVal)) {
            return false;
        }

        if (!recursiveValid(root.right, currentNodeVal, bigger)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
//        node2.right = node3;

        Leetcode_98_566 code = new Leetcode_98_566();
        boolean validBST = code.isValidBST(node2);
        System.out.println(validBST);
    }
}
