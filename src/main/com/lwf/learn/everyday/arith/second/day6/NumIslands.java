package com.lwf.learn.everyday.arith.second.day6;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/number-of-islands/
 * @author: liuwenfei14
 * @date: 2022-04-18 11:13
 */
public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int num=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]=='1'){
                        dp(grid,i,j);
                        num++;
                    }
                }
            }
            return num;
        }
        public  void dp(char[][] grid,int x,int y){
            grid[x][y]='0';
            for (int i = 0; i < 4; i++) {
                int newx = x + xStep[i];
                int newy = y + yStep[i];
                if (newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&&grid[newx][newy]=='1'){
                    dp(grid,newx,newy);
                }
            }
        }
        int[] xStep={1,-1,0,0};
        int[] yStep={0,0,1,-1};
    }
}
