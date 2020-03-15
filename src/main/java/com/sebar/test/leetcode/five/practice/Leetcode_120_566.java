package com.sebar.test.leetcode.five.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/description/
 * 120.三角形最小路径和
 */
public class Leetcode_120_566 {
    /**
     * 三角形路径和
     * 动态规划
     * 时间复杂度O(n^2) 空间复杂度O(N^2)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 特殊情况
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 获取当前这个三角的长度与最大宽度
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        // 构建二位数组表示这个三角形的位置
        int[][] temp = new int[row][col];
        // 设定三角形矩阵的第一个元素值，从他开始进行规划
        temp[0][0] = triangle.get(0).get(0);

        // temp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                // 第一列的元素，没有左上元素可以进行相加比较,
                if (j == 0) {
                    temp[i][j] = temp[i - 1][j] + triangle.get(i).get(j);
                    // 最右边的元素，只有左上元素可以相加比较
                } else if (j == i) {
                    temp[i][j] = temp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    //中间元素，有左上元素和直上元素，则取两者最小值
                    temp[i][j] = Math.min(temp[i - 1][j], temp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        // 最后一行记录着最小的路径值，循环比较取出
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.min(res, temp[row - 1][i]);
        }
        return res;
    }

    /**
     * 空间优化方案
     * 对第i行的求导，只需要第i-1行的dp[i-1][j-1] 和dp[i-1][j] 两个元素即可，不需要存储过多中间变量
     * 采用一维的数组进行第i行的最小路径和存储
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 特殊情况
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //res最大长度==triangle底边长度
        int[] res = new int[triangle.size()];
        res[0] = triangle.get(0).get(0);

        //采用两个变量暂存 prev暂存dp[i-1][j-1] cur暂存dp[i-1][j]
        int prev = 0, curr;
        for (int i = 1; i < triangle.size(); i++) {
            //当前行的数据
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                curr = res[j];
                if (j == 0) {
                    //最左端特殊处理
                    res[j] = curr + list.get(j);
                } else if (j == 1) {
                    // 最右端特殊处理
                    res[j] = prev + list.get(j);
                } else {
                    res[j] = Math.min(curr, prev) + list.get(j);
                }
                prev = curr;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            min = Math.min(res[i], min);
        }
        return min;
    }

    /**
     * 自顶向上动态规划
     *
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 从底开始，如果采用 triangle.size(),则在第一轮循环时会下标越界，则采用+1，最后一行以0处理
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + list.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 自底向上 空间优化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 构建二维数组
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        Leetcode_120_566 coco = new Leetcode_120_566();
        List<Integer> resList1 = new ArrayList<>();
        resList1.add(2);

        List<Integer> resList2 = new ArrayList<>();
        resList2.add(3);
        resList2.add(4);

        List<Integer> resList3 = new ArrayList<>();
        resList3.add(6);
        resList3.add(5);
        resList3.add(7);

        List<Integer> resList4 = new ArrayList<>();
        resList4.add(4);
        resList4.add(1);
        resList4.add(8);
        resList4.add(3);

        List<List<Integer>> resList = new ArrayList<>();
        resList.add(resList1);
        resList.add(resList2);
        resList.add(resList3);
        resList.add(resList4);
//        int i = coco.minimumTotal2(resList);
        int i = coco.minimumTotal3(resList);
        System.out.println(i);
    }
}
