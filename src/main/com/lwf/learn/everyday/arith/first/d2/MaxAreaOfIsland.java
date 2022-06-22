package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 15:08
 */
public class MaxAreaOfIsland {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]==1){
                        int count = bfs(grid, i, j);
                        max=Math.max(max,count);
                    }
                }
            }
            return max;
        }
        public int bfs(int[][] grid,int x,int y){
            int count=0;
            Queue<int[]> qu=new LinkedList<>();
            qu.add(new int[]{x,y});
            grid[x][y]=0;
            while (!qu.isEmpty()){
                int size = qu.size();
                count+=size;
                for (int i = 0; i < size; i++) {
                    int[] pop = ((LinkedList<int[]>) qu).pop();
                    for (int j = 0; j < 4; j++) {
                        int newx=pop[0]+xs[j];
                        int newy=pop[1]+ys[j];
                        if (newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&&grid[newx][newy]==1){
                            qu.add(new int[]{newx,newy});
                            grid[newx][newy]=0;
                        }
                    }
                }
            }
            return count;
        }
        int[] xs={-1,1,0,0};
        int[] ys={0,0,-1,1};
    }
}
