package com.sebar.test.reviewleetcode.three;

/**
 * 扫雷默写
 */
public class Minesweeper_529_2 {
    //相对位置
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;

        if (x < 0 || y < 0 || x >= r || y >= c) {
            // 过界了
            return;
        }

        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            // 检验是否需要递归相邻结点
            int count = judge(board, x, y);
            // 周围没有雷
            if (count == 0) {
                // 继续深一层
                for (int i = 0; i < 8; i++) {
                    dfs(board, x + dx[i], y + dy[i]);
                }
            } else {
                // 有雷
                board[x][y] = (char) (count + '0');
            }
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    /**
     * 验证八个方位是否有雷
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    private int judge(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newY < 0 || newX >= r || newY >= c) {
                continue;
            }

            if (board[newX][newY] == 'M') {
                ++count;
            }
        }
        return count;
    }
}
