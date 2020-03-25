package com.sebar.test.reviewleetcode.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 */
public class NumberOfIslands_200_1 {
    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    /**
     * 深度优先搜索
     *
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        // recursive terminator
        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') {
            return;
        }
        // process on current level
        grid[r][c] = '0';
        // drill down
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /**
     * 广度优先搜索
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    // 变成0
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        Integer id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nr;
                        if (row - 1 > 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                    return numIslands;
                }
            }
        }
        return numIslands;
    }
}
