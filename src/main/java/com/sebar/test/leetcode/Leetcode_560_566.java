package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liguang
 * @distruction https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * N叉树的后序遍历  左--》右--》根
 */
public class Leetcode_560_566 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        postRecursive(root, resList);
        return resList;
    }

    /**
     * 后序遍历--左--》右--》根
     *
     * @param root
     * @param resList
     */
    private void postRecursive(Node root, List<Integer> resList) {
        // terminator
        if (root.children == null) {
            resList.add(root.val);
            return;
        }

        // process login
        for (Node node : root.children) {
            // 再深入进去 drill down
            postRecursive(node, resList);
        }
        // 再将根加进去
        resList.add(root.val);

        return;
    }

    /**
     * 用栈的方式解决后序遍历N叉树
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderSolutionWithStack(Node root) {
        LinkedList<Integer> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }

        // 创建一个栈，用于元素压入栈中，
        LinkedList<Node> nodeStack = new LinkedList<>();
        // 将头结点压入栈中
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            //
            Node currentNode = nodeStack.pollLast();
            resList.addFirst(currentNode.val);

            if (currentNode.children == null) {
                continue;
            }
            for (Node child : currentNode.children) {
                if (child != null) {
                    nodeStack.add(child);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Node rootNode = new Node(1);

        Node secondNode1 = new Node(3);
        Node secondNode2 = new Node(2);
        Node secondNode3 = new Node(4);

        Node thirdNode1 = new Node(5);
        Node thirdNode2 = new Node(6);

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(secondNode1);
        nodeList.add(secondNode2);
        nodeList.add(secondNode3);

        List<Node> nodeList2 = new ArrayList<>();
        nodeList2.add(thirdNode1);
        nodeList2.add(thirdNode2);

        rootNode.children = nodeList;
        secondNode1.children = nodeList2;

        Leetcode_560_566 e = new Leetcode_560_566();
//        List<Integer> postorder = e.postorder(rootNode);
        List<Integer> integerList = e.postOrderSolutionWithStack(rootNode);
        System.out.println(1);
//        System.out.println(postorder);
    }
}
