package com.sebar.test.dailyexercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author LG-QCY
 * @Date :2020/3/29 19:15
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * 1162. 地图分析
 */
public class Leetcode_1162_1 {
    /**
     * 广度优先遍历 BFS
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int len = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入到队列中
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 如果只有陆地或者只有海洋
        if (queue.isEmpty() || queue.size() == len * len) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            //全部取出进行遍历
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 上面的方格是海洋
                if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                    //代表访问过了
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                }
                //下面的方格是海洋
                if (r + 1 < len && grid[r + 1][c] == 0) {
                    //代表访问过了
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                // 左边的方格是海洋
                if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                    //代表访问过了
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }

                // 右边的方格是海洋
                if (c + 1 < len && grid[r][c + 1] == 0) {
                    //代表访问过了
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
        return distance;
    }
}
