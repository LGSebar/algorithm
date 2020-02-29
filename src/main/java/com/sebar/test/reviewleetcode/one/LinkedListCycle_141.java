package com.sebar.test.reviewleetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle_141 {
    /**
     * 证明有环--采用hashmap的辅助
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 采用HashSet
        Set<ListNode> setNode = new HashSet<>();
        while (head != null) {
            if (setNode.contains(head)) {
                return true;
            }
            setNode.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 采用快慢指针
     * 时间复杂度O(n) 空间复杂度O(1)
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
