package com.sebar.test.leetcode;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/16
 * @Description
 */
public class Leetcode_25_566 {
    public static void main(String[] args) {
        Leetcode_25_566 solutionOne = new Leetcode_25_566();

        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fiveNode = new ListNode(5);

        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = fourNode;
        fourNode.next = fiveNode;
        fiveNode.next = null;

//        boolean b = solutionOne.hasCycle(firstNode);
//        ListNode node = solutionOne.detectCycle(firstNode);
//        ListNode listNode = solutionOne.reverseKGroup(firstNode, 3);
        ListNode listNode = solutionOne.solutionTwo(firstNode, 3);
        System.out.println(listNode.val);
    }

    /**
     * 先分组，将数据压入栈中，出栈的就是反序的了
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode(-1);
        ListNode p = result;

        while (true) {
            int count = 0;
            ListNode temp = head;

            // 按照K个一次次压入栈中
            while (temp != null && count < k) {
                stack.add(temp);
                temp = temp.next;
                count++;
            }

            // 不足以形成新的一组
            if (count != k) {
                p.next = head;
                break;
            }
            // 出栈
            while (!stack.empty()) {
                p.next = stack.pop();
                // 下移一位
                p = p.next;
            }

            // 整段执行完成后
            p.next = temp;
            head = temp;
        }
        return result.next;
    }

    /**
     * 分区域进行翻转
     *
     * @param head
     * @param k
     */
    public ListNode solutionTwo(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 快速跳转到翻转位置节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转
            prev.next = reverseNode(start);

            start.next = next;

            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverseNode(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
