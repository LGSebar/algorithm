package com.sebar.test.reviewleetcode.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minesweeper/description/
 * 529.扫雷游戏
 */
public class Minesweeper_529_1 {
    // 相邻位置
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return;
        }

        // 如果是e,才进行判断是否要递归相邻结点
        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            int count = judge(board, x, y);
            // 如果为0，则进行递归，不为0，则更新当前节点的值为地雷数量
            if (count == 0) {
                for (int i = 0; i < 8; i++) {
                    dfs(board, x + dx[i], y + dy[i]);
                }
            } else {
                board[x][y] = (char) (count + '0');
            }
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    /**
     * 判断当前节点相邻的地雷数量
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
        // 判断周围的八个方格
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * bfs
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard2(char[][] board, int[] click) {
        int r = board.length;
        int c = board[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(click[0], click[1]));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (board[x][y] == 'E') {
                board[x][y] = 'B';
                int count = judge(board, x, y);
                if (count == 0) {
                    for (int i = 0; i < 8; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        if (newX < 0 || newY < 0 || newX >= r || newY >= c) {
                            continue;
                        }
                        queue.offer(new Node(newX, newY));
                    }
                } else {
                    board[x][y] = (char) (count + '0');
                }
            } else if (board[x][y] == 'M') {
                board[x][y] = 'X';
            }
        }
        return board;
    }

    public static void main(String[] args) {
        Minesweeper_529_1 coco = new Minesweeper_529_1();
        char[][] board = new char[4][5];
        board[0][0] = 'E';
        board[0][1] = 'E';
        board[0][2] = 'E';
        board[0][3] = 'E';
        board[0][4] = 'E';
        board[1][0] = 'E';
        board[1][1] = 'E';
        board[1][2] = 'M';
        board[1][3] = 'E';
        board[1][4] = 'E';
        board[2][0] = 'E';
        board[2][1] = 'E';
        board[2][2] = 'E';
        board[2][3] = 'E';
        board[2][4] = 'E';
        board[3][0] = 'E';
        board[3][1] = 'E';
        board[3][2] = 'E';
        board[3][3] = 'E';
        board[3][4] = 'E';

        char[][] board1 = coco.updateBoard(board, new int[]{3, 0});
        System.out.println(board1);
    }
}
