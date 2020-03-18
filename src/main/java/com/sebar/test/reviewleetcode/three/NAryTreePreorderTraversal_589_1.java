package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 589. N叉树的前序遍历
 */
public class NAryTreePreorderTraversal_589_1 {
    /**
     * 迭代递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> resList = new ArrayList<>();
        helper(resList, root);
        return resList;
    }

    /**
     * 递归调用--dfs
     * 根-->左-->右
     *
     * @param resList
     * @param root
     */
    private void helper(List<Integer> resList, Node root) {
        // terminator condition
        if (root == null) {
            return;
        }
        resList.add(root.val);
        // drill down
        for (Node child : root.children) {
            helper(resList, child);
        }
    }

    /**
     * 解决方法二--栈
     *
     * @param node
     * @return
     */
    public List<Integer> solution2(Node node) {
        if (node == null) {
            return null;
        }
        LinkedList<Integer> resList = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            resList.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return resList;
    }
}
