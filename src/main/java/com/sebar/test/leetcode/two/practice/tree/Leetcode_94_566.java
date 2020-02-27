package com.sebar.test.leetcode.two.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liguang
 * @Date 2020/2/19
 * @Description
 */

public class Leetcode_94_566 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        treeSearch(root, integerValList);
        return integerValList;
    }

    /**
     * 递归调用进行中序遍历 左--》根--》右
     *
     * @param root
     * @param integerValList
     */
    private void treeSearch(TreeNode root, List<Integer> integerValList) {
        // terminator
        if (root == null) {
            return;
        }

        // process current logic
        if (root.left != null) {
            // drill down
            treeSearch(root.left, integerValList);
        }
        // 中
        integerValList.add(root.val);
        // 右
        if (root.right != null) {
            // drill down
            treeSearch(root.right, integerValList);
        }

        // reverse current status
        return;
    }

    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public List<Integer> morrisInOrderTraversal(TreeNode root) {
        List<Integer> integerValList = new ArrayList<>();
        // 当前树节点指针
        TreeNode currentNode = root;
        // 前置节点
        TreeNode pre = null;

        while (currentNode != null) {
            // 如果没有左子树节点
            if (currentNode.left == null) {
                integerValList.add(currentNode.val);
                currentNode = currentNode.right;
            } else {
                // 有左子树节点
                pre = currentNode.left;
                // 看看右边还有没有节点,找到右子节点最底层的那一个节点
                while (pre.right != null) {
                    pre = pre.right;
                }

                // 将当前节点的前置指针指向pre的右子树
                pre.right = currentNode;

                // 将当前循环的节点的左子树变成空值
                TreeNode temp = currentNode;
                // 将当前节点的左子树节点，置为root节点，
                currentNode = currentNode.left;
                temp.left = null;
            }
        }
        return integerValList;
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
