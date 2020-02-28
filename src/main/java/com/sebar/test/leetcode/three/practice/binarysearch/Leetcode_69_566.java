package com.sebar.test.leetcode.three.practice.binarysearch;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */

public class Leetcode_69_566 {
    public static void main(String[] args) {
        Leetcode_69_566 code = new Leetcode_69_566();
        int i = code.mySqrt(8);
        System.out.println(i);
    }

    /**
     * 二分查找法解决x平方根求解
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left = 1;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                return (int) mid;
            }

        }
        return (int) right;
    }
}
