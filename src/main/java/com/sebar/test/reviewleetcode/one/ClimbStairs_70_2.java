package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 70. Climbing Stairs
 */

public class ClimbStairs_70_2 {
    /**
     * 第一种记录全部数据
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] newArray = new int[n + 1];
        newArray[1] = 1;
        newArray[2] = 2;
        for (int i = 3; i <= n; i++) {
            newArray[i] = newArray[i - 1] + newArray[i - 2];
        }

        return newArray[n];
    }

    // 用第二种记录最后一个数字的
    public int climbStairsImprove(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }

    // 递归调用
    public int climbStairsRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }
}
