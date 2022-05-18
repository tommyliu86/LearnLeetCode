package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * time 2019-10-23-23:22
 * {@link md/normal/79.md}
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        int[][] indexs=new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(0)&&backTracking(board,word,indexs,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backTracking(char[][] board, String word, int[][] indexs, int x, int y, int length) {
        boolean isTrue = false;
        if (length < word.length() - 1) {
            if (board[x][y] == word.charAt(length)) {
                indexs[x][y] = 1;
                if (!isTrue &&(x-1>=0&&x-1<=board.length-1)&& indexs[x - 1][y] == 0) {
                    isTrue = backTracking(board, word, indexs, x - 1, y, length + 1);
                }
                if (!isTrue&&(x+1>=0&&x+1<=board.length-1) && indexs[x + 1][y] == 0) {
                    isTrue = backTracking(board, word, indexs, x + 1, y, length + 1);
                }
                if (!isTrue&&(y-1>=0&&y-1<=board[0].length-1) && indexs[x][y - 1] == 0) {
                    isTrue = backTracking(board, word, indexs, x, y - 1, length + 1);
                }
                if (!isTrue&&(y+1>=0&&y+1<=board[0].length-1) && indexs[x ][y + 1] == 0) {
                    isTrue = backTracking(board, word, indexs, x, y + 1, length + 1);
                }
                indexs[x][y] = 0;
                return isTrue;
            } else {
                return false;
            }
        } else {
            return board[x][y] == word.charAt(length);
        }
    }
}
