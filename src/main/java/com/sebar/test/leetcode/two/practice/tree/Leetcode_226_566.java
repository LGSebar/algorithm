package com.sebar.test.leetcode.two.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_226_566 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTreeNode(TreeNode root) {
        invertTree(root);
        return root;
    }

    /**
     * 翻转二叉树
     * 思路
     *
     * @param root
     * @return
     */
    public void invertTree(TreeNode root) {
        TreeNode tempNode = root;
        if (tempNode == null || (tempNode.left == null && tempNode.right == null)) {
            return;
        }

        TreeNode otherNode = tempNode.left;
        tempNode.left = tempNode.right;
        tempNode.right = otherNode;

        // 先翻转左边
        invertTree(tempNode.left);
        invertTree(tempNode.right);

    }

    public TreeNode solutionWithQueue(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 构建一个队列，用于存储左右孩子节点
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 父节点新入队列
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            // 出队列
            TreeNode pollNode = nodeQueue.poll();
            // 交换当前的左节点和右节点
            TreeNode tempNode = pollNode.left;
            pollNode.left = pollNode.right;
            pollNode.right = tempNode;

            // 将左右节点压入队列
            if (pollNode.left != null) {
                nodeQueue.add(pollNode.left);
            }
            if (pollNode.right != null) {
                nodeQueue.add(pollNode.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;

        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node9;

        Leetcode_226_566 code = new Leetcode_226_566();

        TreeNode newNode1 = new TreeNode(1);
        TreeNode newNode2 = new TreeNode(2);
        newNode1.left = newNode2;
        TreeNode treeNode = code.invertTreeNode(newNode1);
        System.out.println(1);
    }
}
