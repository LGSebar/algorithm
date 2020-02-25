package com.sebar.test.leetcode.three;

public class Leetcode_50_566 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * 暴力循环，如果n小于0,则转化为1/x,
     * 时间复杂度O(n)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    /**
     * 循环解决
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        double currentAns = x;

        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * currentAns;
            }
            currentAns *= currentAns;
        }

        return ans;
    }

    /**
     * 递归解法
     *
     * @param x
     * @param n
     * @return
     */
    public double recursiveSolution(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return recursive(x, n);
    }

    private double recursive(double x, int n) {
        // recursive terminator
        if (n == 0) {
            return 1.0;
        }

        // process on
        double res = recursive(x, n / 2);
        // drill down
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
        // reverse status
    }

    public static void main(String[] args) {
        Leetcode_50_566 code = new Leetcode_50_566();
//        double v = code.myPow(2.0, 3);
//        double v1 = code.recursiveSolution(2.0, 3);
//        System.out.println(v);
//        System.out.println(v1);
        double myPow2 = code.myPow2(2.0, 3);
        System.out.println(myPow2);
    }
}
