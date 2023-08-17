package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/8/17 8:49
 */
public class Ways {
    /**
     * 动态规划，需要想到：第i次切分，需要右下的蛋糕是能切分i-1次的，那么我们记录的i-1次的切分分法总数，就能得到dp公式了！
     */
    class Solution {
        public int ways(String[] pizza, int k) {
            int mod=1000000007;
            int x = pizza.length;
            int y = pizza[0].length();
            int[][] applys=new int[x+1][y+1];
            int[][][] dps=new int[k][x+1][y+1];
            for (int i = x-1; i >= 0; i--) {
                for (int j = y-1; j >= 0; j--) {
                    applys[i][j]=(pizza[i].charAt(j)=='A'?1:0)+applys[i+1][j]+applys[i][j+1]-applys[i+1][j+1];
                    dps[1][i][j]=applys[i][j]>0?1:0;
                }
            }
            for (int k1 = 2; k1 <= k; k1++) {
                //遍历每个点
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        //两种分法
                        for (int i1 = i+1; i1 < x; i1++) {
                            //当前位置的平果大于切分后的右下角的苹果数量，则表示当前切分可行
                            if (applys[i][j]>applys[i1][j]&&applys[i1][j]>0){
                                dps[k1][i][j]=(dps[k1][i][j]+dps[k1-1][i1][j])%mod;
                            }
                        }
                        for (int j1 = j+1; j1 < y; j1++) {
                            //当前位置的平果大于切分后的右下角的苹果数量，则表示当前切分可行
                            if (applys[i][j]>applys[i][j1]&&applys[i][j1]>0){
                                dps[k1][i][j]=(dps[k1][i][j]+dps[k1-1][i][j1])%mod;
                            }
                        }
                    }
                }
            }
            return dps[k][0][0];
        }
    }
}
