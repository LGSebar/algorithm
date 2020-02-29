package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang
 * @Date 2020/2/29
 * @Description
 */
public class ReverseList_206_2 {
    /**
     * 栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }

        //
        ListNode newListNode = new ListNode(-1);
        ListNode tempNode = newListNode;
        while (!nodeStack.isEmpty()) {
            ListNode node = nodeStack.pop();
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        return newListNode.next;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 递归的方式
     *
     * @param head
     * @return
     */
    public ListNode recursive(ListNode head) {
        // recursive terminator
        if (head == null || head.next == null) {
            return head;
        }

        // process current logic
        // drill down
        ListNode p = recursive(head.next);
        head.next.next = head;
        head.next = null;

        // reverse current status
        return p;
    }

    /**
     * 极端迭代
     *
     * @param head
     * @return
     */
    public ListNode loop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (head.next != null) {
            ListNode nextNextNode = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = nextNextNode;
        }
        return curr;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
