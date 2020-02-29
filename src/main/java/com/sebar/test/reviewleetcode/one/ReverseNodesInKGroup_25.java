package com.sebar.test.reviewleetcode.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class ReverseNodesInKGroup_25 {
    public static void main(String[] args) {
        ReverseNodesInKGroup_25 code = new ReverseNodesInKGroup_25();

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

//        ListNode listNode = code.reverseKGroup(oneNode, 3);
        ListNode listNode = code.recursiveReverse(oneNode, 3);
//        ListNode listNode = code.reverseKGroupWithTail(oneNode, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 快速前进到翻转位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            // 进行反转
            prev.next = reverseNode(start);

            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    /**
     * @return
     */
    private ListNode reverseNode(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 将需要逆转的元素压入栈中
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupWithStack(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                stack.add(temp);
                temp = temp.next;
                count++;
            }

            // 剩下的不足一组，不需要逆转
            if (count < k) {
                p.next = head;
                break;
            }
            // 压入栈中的出栈
            while (!stack.isEmpty()) {
                ListNode listNode = stack.pollLast();
                p.next = listNode;
                p = p.next;
            }
            // 结束第一轮后，将剩余位置赋值到头部
            p.next = temp;
            head = temp;
        }
        return dummy.next;
    }

    /**
     * 尾插法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupWithTail(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            //分组完成
            if (tail == null) {
                break;
            }
            ListNode head1 = prev.next;
            // 位置交换
            while (prev.next != tail) {
                ListNode curr = prev.next;
                prev.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
            }

            prev = head1;
            tail = head1;
        }
        return dummy.next;
    }

    public ListNode recursiveReverse(ListNode head, int k) {
        // recursive terminator
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            //反转列表
            curr = recursiveReverse(curr, k);
            while (count != 0) {
                count--;
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
        }
        // process logic current

        // drill down

        //reverse status
        return head;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
