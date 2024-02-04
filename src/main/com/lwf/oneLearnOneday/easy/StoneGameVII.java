package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1690. 石子游戏 VII
 *
 * @author liuwenfei
 * @date 2024/2/4 8:48
 */
public class StoneGameVII {
    /**
     * 我们用f（i,j)表示 数组i~j时，能从这个数组获取到的最大的分数，那么，就可以使用f（i,j)- max（f（i，j-1）,f(i+1，j))来表示
     * 可以获取的最大分数差。因此我们就获取到了递归的算法
     * 同样的递归可以转换成dp算法，我们可以使用相同的思路进行dp
     * 1.先用直接的递归方法，因为每次都要计算所有的递归，会超时，
     * 2.递归+记忆化搜索，通过添加记忆化数据，进行快速返回 时间会比较长
     * 3.改用dp写法。相当于n*n的时间复杂度
     */
    class Solution {
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            int[] sums = new int[n + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + stones[i - 1];
            }
            int[][] dp=new int[n][n];

            for (int i = 1; i < n; i++) {
                int j=0;
                while (j+i<n){
                    dp[j][j+i]= Math.max(sums[j+i + 1] - sums[j + 1] - dp[j+1][j+i], sums[j+i] - sums[j] -  dp[j][j+i-1]);

                    j++;
                }
            }
            return  dp[0][n-1];
        }

        //递归加记忆化搜索
        public int fn(int[] sums, int i, int j, Map<Integer,Integer> map) {
            if (i == j) return 0;
            int indez = i * 1000 + j;
            if (map.containsKey(indez)){
                return map.get(indez);
            }
            int ans= Math.max(sums[j + 1] - sums[i + 1] - fn(sums, i + 1, j,map), sums[j] - sums[i] - fn(sums, i, j - 1,map));
            map.put(indez,ans);
            return ans;
        }
        //递归调用，会超时
        public int fn(int[] sums, int i, int j) {
            if (i == j) return 0;
            return Math.max(sums[j + 1] - sums[i + 1] - fn(sums, i + 1, j), sums[j] - sums[i] - fn(sums, i, j - 1));
        }
    }
}
