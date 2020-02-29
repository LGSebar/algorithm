package com.sebar.test.reviewleetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class LinkedListCycleii_142 {
    /**
     * 第一种，用set做辅助
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

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // 快慢指针。先找到相遇点，再以同样速度进行前进，再次相遇的地方就是入环点
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
        // 有第一次相遇点，则从第一次相遇点继续开始循环，
        ListNode secondCycleSlow = head;
        ListNode secondCycleFast = together;
        // 相同速度进行前进，再次相遇就是入环点
        while (secondCycleSlow != secondCycleFast) {
            secondCycleSlow = secondCycleSlow.next;
            secondCycleFast = secondCycleFast.next;
        }
        return secondCycleSlow;
    }

    /**
     * 另一种写法
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
            // 追上了
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
