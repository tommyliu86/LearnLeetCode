package com.lwf.oneLearnOneday.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumMoves {
    /**
     * 升级版BFS
     */
    class Solution {
        public int minimumMoves(int[][] grid) {
            int x = grid.length - 1;
            int y = grid[0].length - 1;
            //0 水平，1竖向，保存的是第一个点，第二个点需要判断
            int[][][] marks=new int[x+1][y+1][2];
            Queue<int[]> queue=new LinkedList<>();
            marks[0][0][0]=1;
            int ans=0;
            queue.offer(new int[]{0,0,0});
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    if (poll[0]==x&&poll[1]==y-1&&poll[2]==0) return ans;
                    for (int j = 0; j < steps.length; j++) {
                        int[] step = steps[j];
                        int newx=poll[0]+step[0];
                        int newy=poll[1]+step[1];
                        if (step[2]==1){
                            if (poll[2]==0){
                                if (newx>x-1||newy>y-1||grid[newx+1][newy]==1||grid[newx+1][newy+1]==1){
                                    continue;
                                }
                            }else{

                                    if (newx>x-1||newy>y-1||grid[newx][newy+1]==1||grid[newx+1][newy+1]==1){
                                        continue;
                                    }

                            }
                        }
                        int newz=step[2]==1?(poll[2]==0?1:0) :poll[2];

                        if (newx+(newz==0?0:1)<=x&&newy+(newz==0?1:0)<=y&&grid[newx][newy]!=1&&marks[newx][newy][newz]!=1&&grid[newx+(newz==0?0:1)][newy+(newz==0?1:0)]!=1){
                            marks[newx][newy][newz]=1;
                            queue.offer(new int[]{newx,newy,newz});
                        }

                    }

                }
                    ans++;
            }
            return -1;
        }
        int[][] steps={{0,1,0},{1,0,0},{0,0,1}};
    }
}
