package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 429. N叉树的层序遍历
 */
public class NAryTreeLevelOrderTraversal_429_1 {
    /**
     * n叉树的层级遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> childList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                childList.add(node.val);

                queue.addAll(node.children);
            }
            res.add(childList);
        }
        return res;
    }

    public List<List<Integer>> levelorder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        bfs(res, root, 0);
        return res;
    }

    /**
     * 递归调用进行层级遍历
     *
     * @param res
     * @param root
     * @param level
     */
    private void bfs(List<List<Integer>> res, Node root, int level) {
        // terminator condition
        if (level <= res.size()) {
            res.add(new ArrayList<>());
        }
        // process current logic
        res.get(level).add(root.val);
        // drill down
        for (Node child : root.children) {
            bfs(res, child, level + 1);
        }
        // reverse
        return;
    }
}
