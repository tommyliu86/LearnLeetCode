package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenfei
 * @date 2023/5/26 8:47
 */
public class ShortestPathBinaryMatrix {
    /**
     * 题目分析：矩阵找最短路径，使用广度遍历，通过记录每一个step可以到达的点坐标，同时对已经走过的点进行标记即可
     * 广度遍历BFS
     */
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int lx = grid.length;
            int ly = grid[0].length;
            if (grid[0][0]!=0||grid[lx-1][ly-1]!=0) return -1;
            int[] gap=new int[]{1,0,-1,0,1,1,-1,-1,1};
            int step=1;
            grid[0][0]=1;
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{0,0});
            while (!queue.isEmpty()){
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int j = 1; j < gap.length; j++) {
                        int x=poll[0]+gap[j-1];
                        int y=poll[1]+gap[j];
                        if (x>=0&&x<lx&&y>=0&&y<ly&& grid[x][y]==0){
                            grid[x][y]=step;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }

            return grid[lx-1][ly-1]==0?-1:grid[lx-1][ly-1];
        }
    }
}
