package com.lwf.learn.everyday.arith.second.day11;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-23 17:15
 */
public class Exist {
    public static void main(String[] args) {
        System.out.println((int) Character.MIN_VALUE);
        List<int[]> set = new ArrayList<>();
        set.add(new int[]{1, 1});
        System.out.println(set.contains(new int[]{1, 1}));
    }

    class test {
        public boolean exist(char[][] board, String word) {
            boolean[][] mark = new boolean[board.length][board[0].length];
            char[] target = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == target[0]) {
                        mark[i][j] = true;
                        if (recursive(board, target, 1, new int[]{i, j}, mark)) {
                            return true;
                        }
                        mark[i][j] = false;
                    }
                }
            }
            return false;
        }

        public boolean recursive(char[][] board, char[] target, int index, int[] xy, boolean[][] mark) {
            if (index == target.length) {
                return true;
            }
            char targ = target[index];
            for (int i = 0; i < 4; i++) {
                int newx = xy[0] + xstep[i];
                int newy = xy[1] + ystep[i];
                if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length&&targ==board[newx][newy]) {
                    if (!mark[newx][newy]) {
                        mark[newx][newy]=true;
                        if (recursive(board, target, index + 1, new int[]{newx, newy}, mark)){
                            return true;
                        }
                        mark[newx][newy]=false;
                    }
                }
            }
            return false;

        }

        int[] xstep = {-1, 1, 0, 0};
        int[] ystep = {0, 0, -1, 1};
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] mark = new boolean[board.length][board[0].length];
            char[] target = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == target[0]) {
                        if (recursive(board, target, 0, new int[]{i, j}, mark)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean recursive(char[][] board, char[] target, int index, int[] xy, boolean[][] mark) {
            if (index == target.length) {
                return true;
            }
            char targ = target[index];
            if (targ != board[xy[0]][xy[1]]) {
                return false;
            } else {
                if (index == target.length - 1) {
                    return true;
                }
                mark[xy[0]][xy[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int newx = xy[0] + xstep[i];
                    int newy = xy[1] + ystep[i];
                    if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
                        if (!mark[newx][newy] && recursive(board, target, index + 1, new int[]{newx, newy}, mark)) {
                            return true;
                        }
                    }
                }
                mark[xy[0]][xy[1]] = false;
                return false;
            }
        }

        int[] xstep = {-1, 1, 0, 0};
        int[] ystep = {0, 0, -1, 1};
    }

}
