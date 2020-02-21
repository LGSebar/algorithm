package com.sebar.test.leetcode;

import java.util.Stack;

/**
 * @author liguang
 * @Date 2020/2/21
 * @Description
 */

public class Leetcode_155_566 {



    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minNumStack = new Stack<>();

    public Leetcode_155_566() {
    }

    public static void main(String[] args) {
        Leetcode_155_566 code = new Leetcode_155_566();
        code.push(-2);
        code.push(0);
        code.push(-3);

        System.out.println(code.getMin());

        code.pop();
        System.out.println(code.top());
        System.out.println(code.getMin());
    }

    public void push(int x) {
        // 正常的元素入栈，再跟最小的栈顶元素比较，大于，则原元素出栈，新的入栈
        stack.add(x);
        if (minNumStack.isEmpty() || minNumStack.peek() >= x) {
            minNumStack.add(x);
        } else {
            minNumStack.add(minNumStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minNumStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNumStack.peek();
    }
}
