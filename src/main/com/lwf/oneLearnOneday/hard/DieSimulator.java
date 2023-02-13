package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/2/10 9:33
 */
public class DieSimulator {
    /**
     * 动态规划，考虑点数的最大长度的计算即可，mod计算需要特别注意！！！
     */
    class Solution {
        public int dieSimulator(int n, int[] rollMax) {
            int mod=1000000007;
            int[][] mark=new int[n+1][6];
            int preCount=1;
            for (int i = 1; i < mark.length; i++) {
                int curCount=0;
                for (int j = 0; j < mark[i].length; j++) {
                    mark[i][j]= preCount;

                    int max = rollMax[j];
                    if (i-1>max){
                        for (int k = 0; k < 6; k++) {
                            if (k==j) continue;
                            mark[i][j]= (mod+mark[i][j]- mark[i-max-1][k])%mod;
                        }
                    }else if (i-1==max){
                        mark[i][j]--;
                    }
                    curCount=( mark[i][j]+curCount)%mod;
                }
                preCount=curCount;
            }
            return (int) (preCount%1000000007);
        }
    }
}
