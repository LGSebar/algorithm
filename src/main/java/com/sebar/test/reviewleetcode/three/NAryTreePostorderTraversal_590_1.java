package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal_590_1 {
    /**
     * 后序遍历--左--》右-->根
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> resList = new ArrayList<>();
        helper(resList, root);
        return resList;
    }

    /**
     * 递归调用进行循环
     *
     * @param resList
     * @param root
     */
    private void helper(List<Integer> resList, Node root) {
        // terminator condition
        if (root.children == null) {
            resList.add(root.val);
            return;
        }
        // process current logic

        //drill down
        for (Node child : root.children) {
            helper(resList, child);
        }
        //加入根节点
        resList.add(root.val);
        return;
    }

    /**
     * 解决方法二：队列
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> resList = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.push(root);

        while (!queue.isEmpty()) {
            Node node = queue.pollLast();
            resList.addFirst(node.val);
            for (Node child : node.children) {
                queue.push(child);
            }
        }
        return resList;
    }
}
