package com.sebar.test.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author liguang
 * @Date 2020/2/21
 * @Description
 */

public class Leetcode_239_566 {
    public static void main(String[] args) {
        Leetcode_239_566 code = new Leetcode_239_566();
        int[] ints = code.maxSlidingWindowWithPriorityDeque(new int[]{1,3,-1,-3,5,3,6,7}, 1);
    }

    /**
     * 暴力解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        // 循环切除滑动窗口的数组
        int[] maxArray = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            // 找到当前temp数组最大值
            int maxNum = Integer.MIN_VALUE;
            for (int i1 = i; i1 < i + k; i1++) {
                maxNum = Math.max(maxNum, nums[i1]);
            }
            maxArray[i] = maxNum;
        }
        return maxArray;
    }

    /**
     * 队列的形式解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int[] r = new int[nums.length - k + 1];
        // 记录最大元素的下标
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 队列左边的元素最大,将最后一个出栈
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            //判断队首元素是否已经在窗口之外,保证队列中有k数字
            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }

            // k个数字的队列形成后，向结果集添加元素
            if (i >= k - 1) {
                r[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return r;
    }

    /**
     * 采用大顶堆
     * PriorityQueue默认小顶堆，将比较方式反转变成大顶堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowWithPriorityDeque(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int[] r = new int[nums.length - k + 1];
        // 记录最大元素的下标
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (q.size() == k) {
                q.remove(nums[i - k]);
            }
            q.add(nums[i]);
            if (i >= k - 1) {
                // k个数字的队列形成后，向结果集添加元素
                r[i - k + 1] = q.peek();
            }
        }
        return r;
    }
}
