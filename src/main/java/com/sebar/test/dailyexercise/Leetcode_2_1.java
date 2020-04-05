package com.sebar.test.dailyexercise;

/**
 * @Author LG-QCY
 * @Date :2020/3/27 20:54
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 2. 两数相加
 */
public class Leetcode_2_1 {
    /**
     * 迭代
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newListNode = new ListNode(-1);
        ListNode tempNode = newListNode;
        int tempVal = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = tempVal + x + y;
            tempNode.next = new ListNode(sum % 10);
            tempVal = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        if (tempVal != 0) {
            tempNode.next = new ListNode(tempVal);
        }

        return newListNode.next;
    }

    public static void main(String[] args) {
        Leetcode_2_1 coco = new Leetcode_2_1();
        ListNode l12 = new ListNode(2);
        ListNode l14 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l12.next = l14;
        l14.next = l13;

        ListNode l25 = new ListNode(5);
        ListNode l26 = new ListNode(6);
        ListNode l24 = new ListNode(4);

        l25.next = l26;
        l26.next = l24;

        ListNode listNode = coco.addTwoNumbers(l12, l25);
        System.out.println(listNode);
    }
}
