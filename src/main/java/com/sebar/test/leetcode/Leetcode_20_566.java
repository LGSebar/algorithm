package com.sebar.test.leetcode;

import org.springframework.util.StringUtils;

public class Leetcode_20_566 {
    /**
     * 检验字符串是不是合法
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        // 一次走两步
        char[] charsString = s.toCharArray();
        for (int i = 0; i < charsString.length; i++) {
            for (int j = i + 1; j < charsString.length; j++) {
                if ((charsString[i] == '(' && charsString[j] == ')')
                        || (charsString[i] == '{' && charsString[j] == '}')
                        || (charsString[i] == '[' && charsString[j] == ']')) {
                    charsString[i] = ' ';
                    charsString[j] = ' ';
                    break;
                } else {
                    break;
                }
            }
        }

        String s1 = String.valueOf(charsString);
        return StringUtils.isEmpty(s1.trim());
    }

    public static void main(String[] args) {
        Leetcode_20_566 code = new Leetcode_20_566();
        boolean valid = code.isValid("{[]}");
        System.out.println(valid);
    }
}
