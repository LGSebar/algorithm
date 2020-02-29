package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang
 * @Date 2020/2/29
 * @Description
 */

public class MergeTwoSortedLists_1 {
    /**
     * 时间复杂度：O(m+n) 空间复杂度O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 极简
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l2 == null ? l1 : l2;
        }
        ListNode first = (l1.val < l2.val) ? l2 : l1;
        first.next = mergeTwoLists3(first.next, first == l1 ? l2 : l1);
        return first;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode prev = headNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 看哪个先空了，则另一个拼后面
        prev.next = l1 == null ? l2 : l1;

        return headNode.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
