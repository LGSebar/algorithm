package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 * 515.在每个树行中找最大值
 */
public class FindLargestValueInEachTreeRow_515_1 {
    /**
     * bfs
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                maxValue = Math.max(node.val, maxValue);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(maxValue);
        }
        return resList;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        dfs(root, 0, resList);
        return resList;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @param level
     * @param resList
     */
    private void dfs(TreeNode root, int level, List<Integer> resList) {
        // 终止条件
        if (root == null) {
            return;
        }
        if (resList.size() == level) {
            resList.add(level, Integer.MIN_VALUE);
        }

        resList.set(level, Math.max(resList.get(level), root.val));
        if (root.left != null) {
            dfs(root.left, level + 1, resList);
        }
        if (root.right != null) {
            dfs(root.right, level + 1, resList);
        }

    }
}
