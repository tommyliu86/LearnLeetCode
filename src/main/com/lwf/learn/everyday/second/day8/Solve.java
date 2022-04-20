package com.lwf.learn.everyday.second.day8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-20 20:39
 */
public class Solve {
    class Solution {
        public void solve(char[][] board) {
            Queue<int[]> queue = new LinkedList<>();
            int lx = board.length;
            int ly = board[0].length;

            for (int i = 0; i < ly; i++) {
                if (board[0][i] == 'O') {
                    board[0][i] = '1';
                    queue.add(new int[]{0, i});
                }
                if (board[lx - 1][i] == 'O') {
                    board[lx - 1][i] = '1';
                    queue.add(new int[]{lx - 1, i});
                }
            }
            for (int i = 0; i < lx; i++) {
                if (board[i][0] == 'O') {
                    board[i][0] = '1';
                    queue.add(new int[]{i, 0});
                }
                if (board[i][ly - 1] == 'O') {
                    board[i][ly - 1] = '1';
                    queue.add(new int[]{i, ly - 1});
                }

            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int newX = xstep[j] + poll[0];
                        int newY = ystep[j] + poll[1];
                        if (newX >= 0 && newX < lx && newY >= 0 && newY < ly && board[newX][newY] == 'O') {
                            board[newX][newY] = '1';
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j]=='1'){
                        board[i][j]='O';
                    } else if (board[i][j]=='O'){
                        board[i][j]='X';
                    }
                }
            }
        }

        int[] xstep = {-1, 1, 0, 0};
        int[] ystep = {0, 0, -1, 1};
    }
}
