package com.lwf.learn.everyday.arith.first.d2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-21 15:44
 */
public class UpdateMatrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] rtn=new int[mat.length][mat[0].length];
            boolean[][] used=new boolean[mat.length][mat[0].length];

            Queue<int[]> queue=new LinkedList<>();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j]==0){
                        queue.offer(new int[]{i,j});
                        used[i][j]=true;

                    }
                }
            }
            int dis=0;
            while (!queue.isEmpty()){
                int size = queue.size();
                dis++;
                for (int i = 0; i < size; i++) {
                    int[] pop = ((LinkedList<int[]>) queue).pop();
                    for (int j = 0; j < 4; j++) {

                        int newx=pop[0]+xstep[j];
                        int newy=pop[1]+ystep[j];
                        if (newx>=0&&newx<mat.length&&newy>=0&&newy<mat[0].length&&!used[newx][newy]){
                            queue.offer(new int[]{newx,newy});
                            used[newx][newy]=true;
                            rtn[newx][newy]=dis;
                        }
                    }
                }

            }
            return rtn;
        }
        int[] xstep=new int[]{-1,1,0,0};
        int[] ystep=new int[]{0,0,-1,1};
    }
}
