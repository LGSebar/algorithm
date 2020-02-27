package com.sebar.test.leetcode.one.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang
 * @Date 2020/2/16
 * @Description https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Leetcode_141_566 {
    public static void main(String[] args) {
        Leetcode_141_566 solutionOne = new Leetcode_141_566();

        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(0);
        ListNode fourNode = new ListNode(4);

        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = fourNode;
        fourNode.next = null;

//        boolean b = solutionOne.hasCycle(firstNode);
        Boolean b = solutionOne.solutionTwo(firstNode);
        System.out.println(b);
    }

    /**
     * 判断当前链表是不是环状的
     * 思路1：每遍历一个节点，就用额外数组进行记录，如果再次出现，则表示有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 出现了node，则flag置为true
        Map<ListNode, Boolean> nodeMap = new HashMap<>();
        Boolean isExist = false;
        // 循环链表
        while (head != null) {
            // 先判断当前节点是否存在于链表中
            if (nodeMap.containsKey(head)) {
                isExist = true;
                break;
            } else {
                nodeMap.put(head, true);
                // 下一个节点
                head = head.next;
            }
        }
        return isExist;
    }

    /**
     * 双指针追击
     * 一根指针一次前进一步，一根指针一次前进两步，
     * 如果这两根指针相遇了，则代表有环，到底了都没相遇则代表无环
     *
     * @param head
     * @return
     */
    public Boolean solutionTwo(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPoint = head;
        ListNode fasterPoint = head.next;

        while (slowPoint != fasterPoint) {
            // 快指针先到底的
            if (fasterPoint == null || fasterPoint.next == null) {
                return false;
            }

            slowPoint = slowPoint.next;
            fasterPoint = fasterPoint.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
