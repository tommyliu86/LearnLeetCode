package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/17 9:01
 */
public class Largest1BorderedSquare {
    /**
     * dp+遍历
     */
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int[][][] lens=new int[grid.length+1][grid[0].length+1][2];
            int max=0;
            for (int i = 1; i < lens.length; i++) {
                for (int j = 1; j < lens[i].length; j++) {
                    int cur = grid[i - 1][j - 1];
                    if (cur==0){
                        lens[i][j][0]=0;
                        lens[i][j][1]=0;
                    }else{
                        int[] left = lens[i][j-1];
                        int[] up = lens[i - 1][j];
                        lens[i][j][0]=left[0]+1;
                        lens[i][j][1]=up[1]+1;
                        int min=Math.min(left[0],up[1]);
                        int subMax=1;
                        for (int k = min; k > 0; k--) {
                            int[] ll=lens[i][j-k];
                            int[] uu=lens[i-k][j];
                            if (ll[1]>=k+1&&uu[0]>=k+1){
                                subMax=k+1;
                                break;
                            }
                        }
                        max=Math.max(subMax,max);
                    }
                }
            }
            return max*max;
        }
    }
}
