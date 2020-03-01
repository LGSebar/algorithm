package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */

public class ValidParentheses_20_2 {
    /**
     * 借助栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 暴力替代法
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s == "";
    }
}
