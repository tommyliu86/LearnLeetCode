package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/11/21 9:05
 */
public class SoupServings {
    /**
     * 记忆化搜索，把计算过的值记录下来使用的方法
     * 状态压缩，使用二进制来记录要计算的情况组合
     */
    class Solution {

        double[][] dps;
        public double soupServings(int n) {
            int k= n/25+( n%25!=0?1:0);
            if (k>179){
                return 1.0d;
            }
            dps=new double[k+1][k+1];
            return dfs(k,k);
        }
        private double dfs(int i,int j){
            if (i<=0&&j<=0){
                return 0.5;
            }
            if (i<=0){
                return 1;
            }
            if (j<=0){
                return 0;
            }
            if (dps[i][j]==0){

                dps[i][j]=0.25*(dfs(i-4,j)+dfs(i-3,j-1)+dfs(i-2,j-2)+dfs(i-1,j-3));

            }
            return dps[i][j];

        }
    }
    /**
     * dp思路，这里的dp值是剩余的 a，b汤的值。这样可以覆盖到所有的概率
     */
    class Solution1 {
        public double soupServings(int n) {
            int k= n/25+( n%25!=0?1:0);
            if (k>179){
                return 1.0d;
            }
            int[][] steps=new int[][]{{4,0},{3,1},{2,2},{1,3}};

            double[][] dps=new double[k+1][k+1];
            Arrays.fill(dps[0],1);
            dps[0][0]=0.5;
            for (int i = 1; i < dps.length; i++) {
                for (int j = 1; j < dps[i].length; j++) {
                    for (int s = 0; s < steps.length; s++) {
                        int x= Math.max(i - steps[s][0], 0);
                        int y= Math.max(j - steps[s][1], 0);
                        dps[i][j]+=0.25*(dps[x][y]);
                    }
                }
            }
            return dps[k][k];

        }
    }
}
