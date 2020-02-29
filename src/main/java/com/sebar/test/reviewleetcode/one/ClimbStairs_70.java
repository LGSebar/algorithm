package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */

public class ClimbStairs_70 {
    public static void main(String[] args) {
        ClimbStairs_70 code = new ClimbStairs_70();
        int recursive = code.recursive(5);
        System.out.println(recursive);
    }

    /**
     * 斐波那契数列
     * 循环loop
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
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    /**
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * @param n
     * @return
     */
    public int climbImprove(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int nextStep = first + second;
            first = second;
            second = nextStep;
        }
        return second;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int recursive(int n) {
        // recursive termination
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        // drill down
        return recursive(n - 1) + recursive(n - 2);
    }

    /**
     * 斐波那契公式
     *
     * @param n
     */
    public int math(int n) {
        double sqrt = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return (int) (sqrt / fib);
    }
}
