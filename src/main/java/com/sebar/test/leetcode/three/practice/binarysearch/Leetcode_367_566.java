package com.sebar.test.leetcode.three.practice.binarysearch;

/**
 * @author liguang
 * @Date 2020/2/28
 * @Description 367. 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */

public class Leetcode_367_566 {
    /**
     * 二分查找法
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long left = 2;
        long right = num / 2;

        long guessSquared = 1;
        while (left <= right) {
            // 中间数
            long mid = left + (right - left) >> 1;
            guessSquared = mid * mid;
            if (guessSquared == num) {
                return true;
            } else if (guessSquared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 等差数列
     * 所以任意一个平方数可以表示成这样的奇数序列和。
     * 1+3+5+7+...(2N−1)=N^2
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
