package com.sebar.test.leetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Leetcode_102_566 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * def BFS(graph,start,end):
     * visited=set()
     * queue=[]
     * queue.append([start])
     * <p>
     * while queue:
     * node = queue.pop()
     * visited.add(node)
     * <p>
     * process(node)
     * nodes = generate_related_nodes(node)
     * queue.push(nodes)
     * # other processing work
     * ...
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        // 构建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // queue.append([start])
        queue.add(root);
        // 当前节点的等级
        int level = 0;

        while (!queue.isEmpty()) {
            resList.add(new ArrayList<>());
            int size = resList.size();

            for (int i = 0; i < size; i++) {
                // 队列尾部的
                TreeNode treeNode = ((LinkedList<TreeNode>) queue).removeFirst();
                // visited.add(node)
                resList.get(level).add(treeNode.val);

                // process(node)
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            // 更深一层
            level++;

        }
        return resList;
    }

    List<List<Integer>> recurList = new ArrayList<>();

    /**
     * 递归解决层级遍历--bfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        if (root == null) {
            return recurList;
        }
        recursive(0, root);
        return recurList;
    }

    /**
     * 广度优先遍历--递归
     *
     * @param level 层级
     * @param root  节点
     */
    private void recursive(int level, TreeNode root) {
        // 终止条件 recursive terminator
        if (recurList.size() == level) {
            recurList.add(new ArrayList<>());
            return;
        }

        // process logic
        recurList.get(level).add(root.val);

        // drill down
        if (root.left != null) {
            recursive(level + 1, root.left);
        }
        if (root.right != null) {
            recursive(level + 1, root.right);
        }
        // reverse current status

    }
}
