package com.sebar.test.leetcode.one.homework.array;

/**
 * @author liguang
 * @Date 2020/2/27
 * @Description
 */

public class Leetcode_66_566 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
