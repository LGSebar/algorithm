package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class SwapPairs_24 {
    public static void main(String[] args) {
        SwapPairs_24 code = new SwapPairs_24();

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
        ListNode node = code.swapPairs(oneNode);

    }

    /**
     * 递归的方式进行两两交换
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // recursive terminator
        if (head == null || head.next == null) {
            return head;
        }

        // process current logic
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // drill down
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        // reverse current status
        return secondNode;
    }

    /**
     * 迭代
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null || head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 进行交换
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // 交换完成后，前置节点就是第一个，当前头是first.next
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

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
