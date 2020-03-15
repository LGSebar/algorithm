package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 63. 不同路径 II
 */
public class Leetcode_63_566 {
    /**
     * 需要考虑障碍物，如果当前行有一个数字为1，则代表障碍物
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //构建一个跟原始数组一样大小的数组
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        // col
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        }
        // row
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;
        }
        //进行循环 列
        for (int i = 1; i < obstacleGrid.length; i++) {
            // 行
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        Leetcode_63_566 leetcode = new Leetcode_63_566();
//        int[][] obs = new int[3][3];
//        obs[0][0] = 0;
//        obs[0][1] = 0;
//        obs[0][2] = 0;
//        obs[1][0] = 0;
//        obs[1][1] = 1;
//        obs[1][2] = 0;
//        obs[2][0] = 0;
//        obs[2][1] = 0;
//        obs[2][2] = 0;

        int[][] obs = new int[2][1];
        obs[0][0] = 1;
        obs[1][0] = 0;


        int i = leetcode.uniquePathsWithObstacles(obs);
        System.out.println(i);
    }
}
