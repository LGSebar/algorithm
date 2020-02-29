package com.sebar.test.reviewleetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class LinkedListCycle_141_2 {
    /**
     * 有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
