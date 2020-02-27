package com.sebar.test.leetcode.three.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liguang
 * @Date 2020/2/27
 * @Description
 */

public class Leetcode_515_566 {
    List<Integer> resList = new ArrayList<>(16);

    public static void main(String[] args) {
        Leetcode_515_566 code = new Leetcode_515_566();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode33;

        treeNode2.right = treeNode9;
//        List<Integer> integerList = code.largestValues(treeNode1);
        List<Integer> integerList = code.dfsLargestValue(treeNode1);
        System.out.println(integerList);
    }

    /**
     * 515. 在每个树行中找最大值
     * 采用广度优先搜索遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int queueSize = queue.size();
        while (queueSize > 0) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode treeNode = queue.poll();
                maxValue = Math.max(maxValue, treeNode.val);
                // 加入下一个左节点
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                // 加入下一个右节点
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            // 重写队列中元素个数
            queueSize = queue.size();
            // 队列清空后加入最大数字
            resList.add(maxValue);
        }
        return resList;
    }

    /**
     * 深度优先遍历进行数据查找
     *
     * @param root
     * @return
     */
    public List<Integer> dfsLargestValue(TreeNode root) {
        if (root == null) {
            return resList;
        }
        dfs(root, 0);
        return resList;
    }

    /**
     * 深度优先遍历
     *
     * @param root  节点
     * @param level 层数
     */
    private void dfs(TreeNode root, int level) {
        // terminator
        if (root == null) {
            return;
        }

        // process logic
        if (resList.isEmpty() || resList.size() - 1 < level ) {
            resList.add(level, root.val);
        }else if(resList.get(level) < root.val){
            resList.remove(level);
            resList.add(level,root.val);
        }
        // drill down
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
        // reverse status
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
