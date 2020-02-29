package com.sebar.test.reviewleetcode.one;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class ReverseNodesInKGroup_25_2 {
    /**
     * 迭代
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;
        end.next = null;

        while (end.next != null) {
            // 定位到反转位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 其实逆转位置，用于下面反转后衔接
            ListNode start = prev.next;
            // 下一段的位置
            ListNode next = end.next;
            // 反转
            prev.next = reverse(start);
            //衔接
            start.next = next;

            // 重新定位prev和end
            prev = start;
            end = prev;

        }

        return dummy.next;
    }

    /**
     * 进行反转
     *
     * @param start
     * @return
     */
    private ListNode reverse(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 采用栈元素进行处理
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupWithStack(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        Queue<ListNode> stack = new ArrayDeque<>();

        // 切割元素入栈
        while (true) {
            int count = 0;
            ListNode temp = head;
            // 定位到反转位置，并进行入栈
            while (count < k && temp != null) {
                stack.add(temp);
                count++;
                temp = temp.next;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            // 元素出栈
            while (!stack.isEmpty()) {
                p.next = ((ArrayDeque<ListNode>) stack).pollLast();
                p = p.next;
            }

            // 衔接剩余部分
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
                count++;
                tail = tail.next;
            }
            // 分组结束了
            if (count < k) {
                break;
            }
            // 将prev到tail这部分的链表进行反转
            ListNode head1 = prev.next;
            while (prev.next != null) {
                ListNode nextNode = prev.next;
                prev.next = nextNode.next;
                nextNode.next = tail.next;
                tail.next = nextNode;
            }

            prev = head1;
            tail = prev;

        }
        return dummy.next;
    }

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode recursiveReverse(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count++;
            while (count == k) {
                curr = recursiveReverse(curr, k);
                while (count != 0) {
                    ListNode temp = head.next;
                    head.next = curr;
                    curr = head;
                    head = temp;
                    count--;
                }
            }
        }
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
