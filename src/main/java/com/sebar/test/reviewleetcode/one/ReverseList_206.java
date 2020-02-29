package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class ReverseList_206 {
    public static void main(String[] args) {
        ReverseList_206 code = new ReverseList_206();

        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);

        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = fifthNode;
        fifthNode.next = null;

//        ListNode node = code.reverseList(oneNode);
//        ListNode node = code.reverseList2(oneNode);
        ListNode node = code.reverse(oneNode);

    }

    /**
     * 反转node
     * 时间复杂度O(n)
     * 空间复杂度O(n) 使用了一个栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //用栈的方式进行列表反转
        Stack<ListNode> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }
        // 全部入栈后进行出栈
        ListNode newNode = new ListNode(-1);
        ListNode tempNode = newNode;
        while (!nodeStack.isEmpty()) {
            ListNode pop = nodeStack.pop();
            tempNode.next = pop;
            tempNode = tempNode.next;
        }
        // 最后一个尾指针为null
        tempNode.next = null;
        return newNode.next;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归解决
     * 时间复杂度O(n) 空间复杂度O(n)
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
        ListNode p = recursive(head.next);
        head.next.next = head;
        head.next = null;
        // drill down
        return p;
    }

    public ListNode reverse(ListNode head) {
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
