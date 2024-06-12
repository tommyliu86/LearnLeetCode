package com.lwf.oneLearnOneday.normal;

/**
 * @author: liuwenfei
 * @date: 2024/6/12-8:57
 */
public class CountBattleships {
    class Solution {
        public int countBattleships(char[][] board) {
            int count=0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j]=='X'){
                        int x=i+1,y=j+1;
                        while (x<board.length&&board[x][j]=='X'){
                            board[x++][j]='.';
                        }
                        while (y<board[i].length&&board[i][y]=='X'){
                            board[i][y++]='.';
                        }
                        count++;
                        board[i][j]='.';
                    }
                }
            }
            return count;
        }
    }
}
