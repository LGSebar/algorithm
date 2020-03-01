package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */
public class MinStack_155_2 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    MinStack_155_2() {
    }

    //保持同步
    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }

    // 不同步
    public void push2(int x) {
        stack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        }
    }

    // 同步
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

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
