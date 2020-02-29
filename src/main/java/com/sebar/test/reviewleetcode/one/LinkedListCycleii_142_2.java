package com.sebar.test.reviewleetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class LinkedListCycleii_142_2 {
    /**
     * 采用辅助set
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode together = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                together = slow;
                break;
            }
        }
        if (together == null) {
            return null;
        }

        ListNode slow2 = head;
        ListNode fast2 = together;
        while (!slow.equals(fast2)) {
            slow2 = slow2.next;
            fast2 = fast2.next;
        }
        return slow2;
    }

    /**
     * 升级
     *
     * @param head
     * @return
     */
    public ListNode detectCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                ListNode slow2 = head;
                while (!slow2.equals(slow)) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
