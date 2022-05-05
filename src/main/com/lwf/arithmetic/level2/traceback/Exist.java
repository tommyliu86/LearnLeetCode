package com.lwf.arithmetic.level2.traceback;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-04 17:33
 */
public class Exist {
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] mark=new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (find(board,mark,i,j,word,0)){
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean find(char[][] board,boolean[][] mark,int x,int y,String word,int c){
            if (board[x][y]!=word.charAt(c)){
                return false;
            }
            if (c+1==word.length()){
                return true;
            }
            mark[x][y]=true;

            for (int i = 0; i < 4; i++) {
                int newx=x+xstep[i];
                int newy=y+ystep[i];
                if (newx>=0&&newx<board.length&&newy>=0&&newy<board[0].length&&!mark[newx][newy]){
                    if (find(board,mark,newx,newy,word,c+1)) {
                        return true;
                    }

                }
            }
            mark[x][y]=false;
            return false;
        }
        int[] xstep={-1,1,0,0};
        int[] ystep={0,0,-1,1};
    }
}
