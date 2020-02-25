package com.sebar.test.leetcode;

import java.util.Stack;

/**
 * @author liguang
 * @Date 2020/2/21
 * @Description
 */

public class Leetcode_84_566 {
    // 用于存储当前最小柱子的下标
    static Stack<Integer> starkBar = new Stack<>();

    public static void main(String[] args) {
        Leetcode_84_566 code = new Leetcode_84_566();
        System.out.println(code.largestRectangleAreaBigO(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 用于保持栈里面一直有元素，可以进行添加入栈
        starkBar.add(-1);
        for (int i = 0; i < heights.length; i++) {
            // 如果当前不是-1，且遍历元素小于栈顶的元素，则计算栈顶元素的面积，并将栈顶元素清出
            while (starkBar.peek() != -1 && heights[i] <= heights[starkBar.peek()]) {
                maxArea = Math.max(maxArea, (heights[starkBar.pop()] * (i - starkBar.peek() - 1)));
            }
            starkBar.push(i);
        }
        // 最后还有未出栈的元素的时候
        while (starkBar.peek() != -1) {
            // 还有未出栈的元素
            maxArea = Math.max(maxArea, (heights[starkBar.pop()] * (heights.length - starkBar.peek() - 1)));
        }
        return maxArea;
    }

    /**
     * 暴力求解
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaBigO(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                // 找出最低的位置
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                //
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }

        return maxArea;
    }

    public int largestRectangleAreaBigO2(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                // 找出最小的棒子
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }

        return maxArea;
    }
}
