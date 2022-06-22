package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-21 15:51
 */
public class OrangesRotting {
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue=new LinkedList<>();
            int count=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]==2) {
                        queue.offer(new int[]{i,j});
                    }else if (grid[i][j]==1){
                        count++;
                    }
                }
            }
            if (count==0){
                return 0;
            }
            int step=0;
            while (!queue.isEmpty()){
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] pop = ((LinkedList<int[]>) queue).pop();
                    for (int j = 0; j < 4; j++) {
                        int newx=pop[0]+xstep[j];
                        int newy=pop[1]+ystep[j];
                        if (newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&&grid[newx][newy]==1){
                            count--;
                            queue.offer(new int[]{newx,newy});
                            grid[newx][newy]=2;
                        }
                    }
                }
            }
            if (count==0){
                return step-1;
            }else{
                return -1;
            }
        }
        int[] xstep=new int[]{-1,1,0,0};
        int[] ystep=new int[]{0,0,-1,1};
    }
}
