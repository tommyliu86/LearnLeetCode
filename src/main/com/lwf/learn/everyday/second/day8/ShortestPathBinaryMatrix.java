package com.lwf.learn.everyday.second.day8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-20 19:21
 */
public class ShortestPathBinaryMatrix {
    /**
     * 广度优先遍历。按照层序遍历法
     */
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            Queue<int[]> queue=new LinkedList<>();
            if (grid[0][0]==1||grid[grid.length-1][grid.length-1]==1){
                return -1;
            }
            if (grid.length==1){
                return 1;
            }
            queue.add(new int[]{0,0});
            grid[0][0]=1;
            int step=1;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int j = 0; j < 8; j++) {
                        int newX = poll[0] + xstep[j];
                        int newY = poll[1] + ystep[j];
                        if (newX==grid.length-1&&newY==grid.length-1){
                            return step+1;
                        }else{

                            if (newX>=0&&newX<grid.length&&newY>=0&&newY<grid.length&& grid[newX][newY]==0){
                                queue.add(new int[]{newX,newY});
                                grid[newX][newY]=1;
                            }
                        }
                    }
                }
                step++;
            }
            return -1;

        }
        int[] xstep={-1,1,0,0,-1,-1,1,1};
        int[] ystep={0,0,-1,1,-1,1,-1,1};
    }
}
