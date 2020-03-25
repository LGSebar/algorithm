package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * 102. 二叉树的层次遍历
 */
public class BinaryTreeLevelOrderTraversal_102_1 {
    /**
     * bfs 二叉树层级遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> resList = new ArrayList<>();
        int levels = 0;

        while (!queue.isEmpty()) {
            resList.add(new ArrayList<Integer>());
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                resList.get(levels).add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels++;
        }
        return resList;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root, 0, resList);
        return resList;
    }

    /**
     * 深度优先搜素
     *
     * @param root
     * @param level
     * @param resList
     */
    private void dfs(TreeNode root, int level, List<List<Integer>> resList) {
        // stop condition
        if (root == null) {
            return;
        }

        // current logic
        if (resList.size() == level) {
            resList.add(new ArrayList<>());
        }

        resList.get(level).add(root.val);
        // drill down
        dfs(root.left, level + 1, resList);
        dfs(root.right, level + 1, resList);
    }
}
