package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class SwapPairs_24_2 {
    /**
     * 递归解决
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // recursive terminator
        if (head == null || head.next == null) {
            return head;
        }

        //process current logic
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    /**
     * 迭代的方式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = head;
        while (head != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 交换
            prev.next = second;
            first.next = second.next;
            second.next = first;

            //
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

    /**
     * 变态迭代
     *
     * @param head
     * @return
     */
    public ListNode swapPair3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode c = dummy;
        while (c.next != null && c.next.next != null) {
            ListNode first = c.next;
            ListNode second = c.next.next;

            c.next = second;
            first.next = second.next;

            second.next = first;
            c = c.next.next;
        }
        return c.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
