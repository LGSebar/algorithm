package com.sebar.test.leetcode.three.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liguang
 * @Date 2020/2/26
 * @Description
 */

public class Leetcode_51_566 {
    /**
     * 结果集
     */
    List<List<String>> resList = new ArrayList<>();
    /**
     * n 皇后数量
     */
    int n;
    /**
     * 左对角线可存放位置
     */
    int dales[];
    /**
     * 右对角线可存放位置
     */
    int hills[];
    /**
     * 皇后位置
     */
    int queens[];
    /**
     * 棋盘
     */
    int rows[];

    public static void main(String[] args) {
        Leetcode_51_566 code = new Leetcode_51_566();
        List<List<String>> lists = code.solveNQueens(8);
        System.out.println(lists);
    }

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
     * 并且使皇后彼此之间不能相互攻击。
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // 初始化数据
        this.n = n;
        // 生成容纳n个字符的二维数组，与皇后数量一样大
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backTrack(0);
        return resList;
    }

    /**
     * 回溯法解决n皇后问题
     *
     * @param rowIndex 行开始下标
     */
    private void backTrack(int rowIndex) {
        // 循环列，查看下一个皇后是否可以放置
        for (int cowIndex = 0; cowIndex < n; cowIndex++) {
            if (isNotUnderAttack(rowIndex, cowIndex)) {
                // 不在上一个皇后的攻击范围，可以放置皇后
                placeQueue(rowIndex, cowIndex);
                // 查看是不是最后一个皇后放置
                if (rowIndex + 1 == n) {
                    addSolution();
                } else {
                    backTrack(rowIndex + 1);
                }
                // 移除上一个，进行回溯
                removeQueue(rowIndex, cowIndex);
            }
        }
    }

    /**
     * 添加解决方案
     */
    private void addSolution() {
        List<String> solutionList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 皇后所在列
            int colIndex = queens[i];
            StringBuilder builder = new StringBuilder();
            // 皇后所在列前面用*
            for (int j = 0; j < n; j++) {
                builder.append("*");
            }
            builder.append("Q");
            // 皇后后面的用*
            for (int x = 0; x < n - colIndex - 1; x++) {
                builder.append("*");
            }
            solutionList.add(builder.toString());
        }
        resList.add(solutionList);
    }

    /**
     * 移除皇后，进行回溯
     *
     * @param rowIndex 行下标
     * @param cowIndex 列下标
     */
    private void removeQueue(int rowIndex, int cowIndex) {
        // 将皇后所在的列变为0
        queens[rowIndex] = 0;
        // 将列的攻击位置取消
        rows[cowIndex] = 0;
        // 左对角线攻击位置取消标识
        dales[cowIndex + rowIndex] = 0;
        // 右对角线攻击位置取消标识
        hills[rowIndex - cowIndex + 2 * n] = 0;
    }

    /**
     * 放置皇后
     *
     * @param rowIndex 行下标
     * @param cowIndex 列下标
     */
    private void placeQueue(int rowIndex, int cowIndex) {
        // 标识每一层皇后所在的列数，
        queens[rowIndex] = cowIndex;
        // 标识当前列已经有了一个皇后，当前列都处在攻击位置
        rows[cowIndex] = 1;
        // 将左对角线位置标识为攻击范围，
        dales[rowIndex + cowIndex] = 1;
        // 将右对角线位置标识为攻击范围
        hills[rowIndex - cowIndex + 2 * n] = 1;
    }

    /**
     * 检验当前位置是不是出于前面放置的皇后攻击位置，处于攻击位置咋不能放置
     *
     * @param rowIndex 行下标
     * @param cowIndex 列下标
     * @return
     */
    private boolean isNotUnderAttack(int rowIndex, int cowIndex) {
        int row = rows[cowIndex];
        int hill = hills[rowIndex - cowIndex + 2 * n];
        int dale = dales[rowIndex + cowIndex];
        boolean b = row + hill + dale == 0;
        return b;
    }
}
