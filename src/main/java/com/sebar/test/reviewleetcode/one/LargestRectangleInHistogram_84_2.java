package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */

public class LargestRectangleInHistogram_84_2 {
    /**
     * 最大面积
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexStack = new Stack<>();
        indexStack.add(-1);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            // 不是初始值，且当前入栈元素比栈顶小，开始清算面积
            while (indexStack.peek() != -1 && heights[i] < heights[indexStack.peek()]) {
                maxArea = Math.max(maxArea, heights[indexStack.pop()] * (i - heights[indexStack.peek()] - 1));
            }
            indexStack.add(i);
        }
        while (indexStack.peek() != -1) {
            // 宽度等于当前距离到队尾的距离
            maxArea = Math.max(maxArea, heights[indexStack.pop()] * (heights.length - 1 - heights[indexStack.peek()]));
        }
        return maxArea;
    }
}
