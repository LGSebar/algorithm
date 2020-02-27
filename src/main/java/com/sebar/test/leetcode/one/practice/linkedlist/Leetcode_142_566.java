package com.sebar.test.leetcode.one.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang
 * @Date 2020/2/16
 * @Description https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Leetcode_142_566 {

    public static void main(String[] args) {
        Leetcode_142_566 solutionOne = new Leetcode_142_566();

        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode thridNode = new ListNode(0);
        ListNode fourNode = new ListNode(4);

        firstNode.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = fourNode;
        fourNode.next = secondNode;

//        boolean b = solutionOne.hasCycle(firstNode);
//        ListNode node = solutionOne.detectCycle(firstNode);
        ListNode listNode = solutionOne.solutionTwo(firstNode);
        System.out.println(listNode.val);
    }

    /**
     * 判断当前链表是不是环状的
     * 思路1：每遍历一个节点，就用额外数组进行记录，如果再次出现，则表示有环
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 用来记录每个节点，如果出现环状，则返回其初次进入map的下标位置
        Map<ListNode, Boolean> nodeMap = new HashMap<>();

        while (head != null) {
            if (nodeMap.containsKey(head)) {
                return head;
            } else {
                nodeMap.put(head, true);
                head = head.next;
            }
        }
        return null;
    }

    /**
     * 快慢指针的方式进行解答
     *
     * @param head
     * @return
     */
    public ListNode solutionTwo(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowNode = head;
        ListNode fasterNode = head;

        // 获取第一次相遇的地点
        ListNode firstMeetNode = null;
        while (fasterNode != null && fasterNode.next != null) {
            slowNode = slowNode.next;
            fasterNode = fasterNode.next.next;

            if (slowNode == fasterNode) {
                firstMeetNode = slowNode;
                break;
            }
        }

        // 没有首次相遇节点，则
        if (firstMeetNode == null) {
            return null;
        }

        System.out.println("首次相遇点L:" + firstMeetNode.val);
        // 再次进行循环
        ListNode secondCycleSlowNode = head;
        ListNode secondCycleFasterNode = firstMeetNode;

        while (secondCycleFasterNode != secondCycleSlowNode) {
            secondCycleSlowNode = secondCycleSlowNode.next;
            secondCycleFasterNode = secondCycleFasterNode.next;
        }
        return secondCycleSlowNode;
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
