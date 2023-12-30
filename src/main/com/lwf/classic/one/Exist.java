package com.lwf.classic.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/1/30 9:46
 */
public class Exist {
    /**
     * 使用相同二维数组进行mark，回溯
     */
    class Solution {
        int[][] steps=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        public boolean exist(char[][] board, String word) {
            int[][] marks=new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board,i,j,word,0,marks)){
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean exist(char[][] board, int x, int y, String word,int i,int[][] marks){

            if (word.charAt(i)==board[x][y]) {
                marks[x][y]=1;
                boolean ok=false;
                for (int j = 0;i<word.length()-1&& j < steps.length; j++) {
                    int[] step = steps[j];
                    int nx=x+step[0];
                    int ny=y+step[1];
                    if (nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&marks[nx][ny]==0){
                        marks[nx][ny]=1;
                        ok=exist(board,nx,ny,word,i+1,marks);
                        if (ok){
                            return true;
                        }
                        marks[nx][ny]=0;
                    }
                }
                marks[x][y]=0;
                return i==word.length()-1;
            }else{
                return false;
            }
        }

    }
    /**
     * 暴力思路，直接BFS 回溯
     */
    class Solution1 {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board,i,j,word,0,new HashSet<Integer>())){
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean exist(char[][] board, int x, int y, String word,int i,Set<Integer> sets){
            if (i==word.length()){
                return true;
            }
            if (word.charAt(i)==board[x][y]) {
                sets.add(100+x*10+y);
                boolean ok=false;
                for (int j = 0; j < steps.length; j++) {
                    int[] step = steps[j];
                    int nx=x+step[0];
                    int ny=y+step[1];
                    if (nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&!sets.contains(100+nx*10+ny)){
                        sets.add(100+nx*10+ny);
                        ok=exist(board,nx,ny,word,i+1,sets);
                        if (ok){
                            return true;
                        }
                        sets.remove(100+nx*10+ny);
                    }
                }
                return i==word.length()-1;
            }else{
                return false;
            }
        }

        int[][] steps=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    }
}
