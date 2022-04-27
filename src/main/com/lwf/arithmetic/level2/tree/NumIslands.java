package com.lwf.arithmetic.level2.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-27 09:02
 */
public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int count=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]==1){
                        count++;
                        grid[i][j]=0;
                        recursive(grid,i,j);
                    }
                }
            }
            return count;
        }
        public void recursive(char[][] grid,int x,int y){
            for (int i = 0; i < 4; i++) {
                int newx=x+xstep[i];
                int newy=y+ystep[i];
                if (newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&& grid[newx][newy]==1){
                    grid[newx][newy]=0;
                    recursive(grid,newx,newy);
                }
            }
        }
        int[] xstep={-1,1,0,0};
        int[] ystep={0,0,1,-1};
    }
}
