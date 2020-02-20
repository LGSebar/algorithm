package com.sebar.test.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liguang
 * @Date 2020/2/20
 * @Description
 */

public class Leetcode_104_566 {
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

        Leetcode_104_566 code = new Leetcode_104_566();

        System.out.println(code.maxDepth(node3));
    }

    /**
     * 最大深度
     *
     * @param root
     * @return
     */
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

    /**
     * 采用队列的方式进行最深深度探测
     *
     * @param root
     * @return
     */
    public int stackMaxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> treeNodeQueue = new LinkedList<>();
        // 先将主节点放入 ,第一层
        treeNodeQueue.add(new Pair<>(root, 1));
        // 深度
        int depth = 0;

        while (!treeNodeQueue.isEmpty()) {
            // 看看有没有左右节点，有左右节点的，将左右节点压入栈中
            Pair<TreeNode, Integer> pollNode = treeNodeQueue.poll();
            // 当前节点
            root = pollNode.getKey();
            Integer curValue = pollNode.getValue();

            if (root != null) {
                // 比较最大值
                depth = Math.max(depth, curValue);
                // 将左节点加入队列
                treeNodeQueue.add(new Pair<>(root.left, depth + 1));
                // 将右节点加入队列
                treeNodeQueue.add(new Pair<>(root.right, depth + 1));
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
