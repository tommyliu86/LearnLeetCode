package com.lwf.learn.everyday.th75;

public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int count=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]=='1'){
                        dfs(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }
        public void dfs(char[][] grid,int x,int y){
            if (grid[x][y]=='0'){
                return;
            }
            grid[x][y]='0';
            for (int i = 0; i < step.length; i++) {
                int[] ints = step[i];
                int nx=ints[0]+x;
                int ny=ints[1]+y;
                if (nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length&&grid[nx][ny]=='1'){
                    dfs(grid,nx,ny);
                }
            }
        }
        int[][] step=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    }
}
