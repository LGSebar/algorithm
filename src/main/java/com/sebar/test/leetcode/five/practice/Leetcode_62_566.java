package com.sebar.test.leetcode.five.practice;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 62.不同路径
 */
public class Leetcode_62_566 {
    /**
     * DP 自底向上
     *
     * @param m 列
     * @param n 行
     *          解题思路，最后一个位置的抵达方式一定是1，自底向上进行数值相加获得每一个格子的行动方案
     * @return 时间复杂度：O(n^2) 空间复杂度O（m*n）
     */
    public int uniquePaths(int m, int n) {
        //构建一个m*n的二位数组
        int[][] nums = new int[m][n];
        // 先以1填充了二维数组最后一列
        Arrays.fill(nums[m - 1], 1);
        // 填充二维数组最后一行
        for (int i = 0; i < nums.length; i++) {
            nums[i][n - 1] = 1;
        }
        // 从倒数第二列开始计算
        for (int i = nums.length - 2; i >= 0; i--) {
            // 获取每一行的数据，从底部开始计算
            int[] colNum = nums[i];
            for (int j = colNum.length - 2; j >= 0; j--) {
                nums[i][j] = nums[i + 1][j] + nums[i][j + 1];
            }
        }
        return nums[0][0];
    }

    /**
     * 空间优化
     * 只用一个一位数组做每一层的转化即可
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[j] += temp[j - 1];
            }
        }
        return temp[n - 1];
    }

    public static void main(String[] args) {
        Leetcode_62_566 code = new Leetcode_62_566();
        int i = code.uniquePaths(7, 3);
        System.out.println(i);
    }
}
