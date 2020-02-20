package com.sebar.test.leetcode;

import java.util.Stack;

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
     * 中序遍历 左-->根-->右
     *
     * @return GLOBALGLB
     * YOUXIN
     */
    double last = -Double.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        Leetcode_98_566 code = new Leetcode_98_566();
        boolean validBST = code.solutionThree(node2);
        System.out.println(validBST);
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
        // 先验证右节点，找出最高边界
        if (!recursiveValid(root.right, currentNodeVal, bigger)) {
            return false;
        }
        // 再验证左节点，找出最低边界
        if (!recursiveValid(root.left, lower, currentNodeVal)) {
            return false;
        }


        return true;
    }

    /**
     * 最佳解答
     *
     * @param root
     * @param minVal
     * @param maxVal
     * @return
     */
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public Boolean solutionTwo(TreeNode root) {
        // terminator
        if (root == null) {
            return true;
        }

        // process logic
        // 先验证左边比根节点大,左边不为空,再比较右边比根节点值大
        if (solutionTwo(root.left)) {
            //
            if (last < root.val) {
                last = root.val;
                return solutionTwo(root.right);
            }
        }
        // drill down 不满足条件则返回false
        return false;
    }

    public Boolean solutionThree(TreeNode node) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!treeNodeStack.isEmpty() || node != null) {
            // 将左边的元素全部压入栈
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            // 一个个出栈
            node = treeNodeStack.pop();
            if (node.val <= inorder) {
                return false;
            }

            inorder = node.val;
            // 验证右边的是不是比当前值小
            node = node.right;
        }
        return true;
    }
}
