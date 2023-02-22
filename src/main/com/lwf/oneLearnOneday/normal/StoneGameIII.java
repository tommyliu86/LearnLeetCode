package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/2/22 18:39
 */
public class StoneGameIII {
    /**
     * 基础的dp适用于固定步骤或者推进的情况，最佳策略的仍然是需要从逆向考虑
     */
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int n = stoneValue.length;
            int[] sum= new int[n +1];
            for (int i = 1; i < sum.length; i++) {
                sum[i]=sum[i-1]+stoneValue[i-1];
            }
            int[] remain=new int[n+1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1;i+j<n+1&& j < 4; j++) {
                    remain[i]= Math.max( sum[n]-sum[i]-remain[i+j],remain[i]);
                }
            }

            if (remain[0]*2>sum[n]){
                return "Alice";
            }else if (remain[0]*2==sum[n]){
                return "Tie";
            }else{
                return "Bob";
            }
        }
    }
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int n = stoneValue.length;
            int[] suffixSum = new int[n];
            suffixSum[n - 1] = stoneValue[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                suffixSum[i] = suffixSum[i + 1] + stoneValue[i];
            }
            int[] f = new int[n + 1];
            // 边界情况，当没有石子时，分数为 0
            // 为了代码的可读性，显式声明
            f[n] = 0;
            for (int i = n - 1; i >= 0; --i) {
                int bestj = f[i + 1];
                for (int j = i + 2; j <= i + 3 && j <= n; ++j) {
                    bestj = Math.min(bestj, f[j]);
                }
                f[i] = suffixSum[i] - bestj;
            }
            int total = 0;
            for (int value : stoneValue) {
                total += value;
            }
            if (f[0] * 2 == total) {
                return "Tie";
            } else {
                return f[0] * 2 > total ? "Alice" : "Bob";
            }
        }
    }


}
