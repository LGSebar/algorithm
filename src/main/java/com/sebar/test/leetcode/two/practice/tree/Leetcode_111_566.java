package com.sebar.test.leetcode.two.practice.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liguang
 * @Date 2020/2/20
 * @Description
 */

public class Leetcode_111_566 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        Leetcode_111_566 code = new Leetcode_111_566();

        System.out.println(code.minDepthWithStack(node3));
    }

    /**
     * 递归中序遍历的方式获取最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        // 如果left不为空
        Integer minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        // 如果right不为空
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }

    /**
     * 用队列的方式寻找最小深度
     *
     * @param root
     * @return
     */
    public int minDepthWithStack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> treeNodeQueue = new LinkedList<>();
        // 最小深度
        int depth = Integer.MAX_VALUE;
        treeNodeQueue.add(new Pair<>(root, 1));

        while (!treeNodeQueue.isEmpty()) {
            // 出队列
            Pair<TreeNode, Integer> pollNode = treeNodeQueue.poll();
            // 当前节点
            root = pollNode.getKey();
            Integer curDepth = pollNode.getValue();
            if (root.left == null && root.right == null) {
                depth = Math.min(curDepth, depth);
            }
            if (root.left != null) {
                treeNodeQueue.add(new Pair<>(root.left, curDepth + 1));
            }
            if (root.right != null) {
                treeNodeQueue.add(new Pair<>(root.right, curDepth + 1));
            }

        }
        return depth;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
