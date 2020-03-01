package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */

public class LargestRectangleInHistogram_84 {
    Stack<Integer> indexStack = new Stack<>();

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 code = new LargestRectangleInHistogram_84();
        System.out.println(code.largestRectangleAreaPower(new int[]{2,1,5,6,2,3}));
    }

    /**
     * 如果元素小于栈顶元素，则进行面积计算，同时出栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 保证栈里面有元素
        indexStack.add(-1);
        for (int i = 0; i < heights.length; i++) {
            while (indexStack.peek() != -1 && heights[i] < heights[indexStack.peek()]) {
                maxArea = Math.max(maxArea, heights[indexStack.pop()] * (i - indexStack.peek() - 1));
            }
            indexStack.push(i);
        }
        // 还有未出栈的
        while (indexStack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[indexStack.pop()] * (heights.length - indexStack.peek() - 1));
        }
        return maxArea;
    }

    /**
     * 暴力求解
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaPower(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int z = i; z <= j; z++) {
                    minHeight = Math.min(minHeight, heights[z]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i+1));
            }
        }
        return maxArea;
    }
}
