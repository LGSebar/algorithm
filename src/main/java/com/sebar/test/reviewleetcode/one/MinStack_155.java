package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */

public class MinStack_155 {
    // 正常元素存储用的栈
    Stack<Integer> stack = new Stack<>();
    // 只记录最小元素的栈
    Stack<Integer> minStack = new Stack<>();

    public MinStack_155() {

    }

    /**
     * 入栈
     * 数据栈和辅助栈在任何时候都同步,数据量一样多，只是记录了最小的元素
     *
     * @param x
     */
    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }

    /**
     * 不同步,minStack只记录最小的那个元素
     *
     * @param x
     */
    public void push2(int x) {
        stack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            minStack.pop();
            stack.pop();
        }
    }
    // 不同步的出栈，原始栈出栈的时候等于最小堆的最小值，则要最小堆也出栈
    public void pop2() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop.equals(minStack.peek())) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }
}
