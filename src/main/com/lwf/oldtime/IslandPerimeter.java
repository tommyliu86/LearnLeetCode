package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-17-0:47
 * {@link 463.md}
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        Thread.yield();
    }
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==0) continue;
                if (j-1<0|| grid[i][j-1]==0){
                    count++;
                }
                if (i-1<0|| grid[i-1][j]==0){
                    count++;
                }
                if (j+1>grid[i].length|| grid[i][j+1]==0){
                    count++;
                }
                if (i+1>grid.length|| grid[i+1][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}
