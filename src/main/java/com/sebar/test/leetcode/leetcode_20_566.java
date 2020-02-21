package com.sebar.test.leetcode;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/21
 * @Description
 */

public class leetcode_20_566 {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        // 循环字符串字节，进行相应符号入栈
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 把有括号压入栈中，
                charStack.push(')');
            } else if (c == '[') {
                charStack.push(']');
            } else if (c == '{') {
                charStack.push('}');
            } else if (charStack.isEmpty() || c != charStack.pop()) {
                return false;
            }
        }
        if (charStack.isEmpty()) {
            return true;
        }
        return false;
    }

}
