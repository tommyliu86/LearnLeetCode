package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/24 16:19
 */
public class PredictTheWinner {
    /**
     * 动态规划，逆向推导，考虑 若只有一个元素时，可以获取得最大是多少，往长度推进，f(i)表示能获取得最大，则f(i)+1表示在首或尾变长
     * 那么，这时能获取得最大，就是 f(i+1）=math.max(sum()-f(i),sum()-f(i_)）,有了公式，我们从i-j最短开始规划即可
     */
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] max=new int[n][n];
            int[] sums=new int[n+1];
            for (int i = 0; i < max.length; i++) {
                max[i][i]=nums[i];
                sums[i+1]=sums[i]+nums[i];
            }

            for (int l = 1; l < n; l++) {
                for (int i = 0; i+l < n; i++) {
                    int j=i+l;
                    max[i][j]=Math.max(  sums[j+1]-sums[i]- max[i+1][j], sums[j+1]-sums[i]- max[i][j-1]);

                }
            }
            int cur = max[0][n - 1];
            if (sums[n]<=cur*2) {
                return true;
            }else{
                return false;
            }
        }
    }
}
