package com.sebar.test.reviewleetcode.one;

import java.util.Stack;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class ValidParentheses_20 {
    public static void main(String[] args) {
        ValidParentheses_20 code = new ValidParentheses_20();
        boolean valid2 = code.isValid2("()[]{}");
        System.out.println(valid2);
    }

    /**
     * 借助栈进行处理，左括号，则将右括号压入栈中，其他符号出栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                charStack.push(')');
            } else if (c == '{') {
                charStack.push('}');
            } else if (c == '[') {
                charStack.push(']');
            } else if (charStack.isEmpty() || c != charStack.pop()) {
                return false;
            }
        }
        return charStack.isEmpty();
    }

    /**
     * 遇到{} () [] 转换成‘’
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        while (s.contains("[]") || s.contains("()") || s.contains("{}")) {
            s = s.replace("[]", "");
            s = s.replace("()", "");
            s = s.replace("{}", "");
        }
        return s == "";
    }
}
