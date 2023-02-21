package com.lwf.oneLearnOneday.hard;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/2/21 8:52
 */
public class MinTaps {
    /**
    * dp 假设 f(i)是到i需要最少几个，f(j)求解：【minj，maxj】，i-minj=最小左点，i-1，最大左点，在此区间中遍历每个f(i)获取最小f
     *
     */
    class Solution {
        public int minTaps(int n, int[] ranges) {
            int[][] points=new int[n+1][2];
            for (int i = 0; i < points.length; i++) {
                points[i]=new int[]{Math.max(0,i- ranges[i]),Math.min(n,i+ranges[i])};
            }
            Arrays.sort(points, Comparator.comparing(a->a[0]));
            int[] dp=new int [n+1];
            Arrays.fill(dp,n+2);
            dp[0]=0;
            int max=0;
            for (int i = 0; i < points.length; i++) {

                int[] rang = points[i];
                if (dp[rang[0]]==n+2){
                    return -1;
                }
                if (rang[1]>=n){
                    return dp[rang[0]]+1;
                }
                for (int j = rang[0]; j <= rang[1]; j++) {
                    dp[j]=Math.min(dp[j],dp[rang[0]]+1);
                }

            }
            return dp[n];
        }
    }

    /**
     * 贪心，该题类似于跳跃到终点的最小次数的那个问题，从一个点出发，找可以达到的最远距离，因此我们可以使用贪心思路，从每个点出发找当前可达的所有点
     * 中的最远，就是+1可以到达的最远，贪心的向后跳跃即可。
     * 这里的难点是想到把灌溉的面积转换成每个点可达的最远距离，
     */
    class Solution1 {
        public int minTaps(int n, int[] ranges) {
            int[] points = new int[n + 1];
            for (int i = 0; i < points.length; i++) {
                int l = Math.max(0, i - ranges[i]);
                int r = Math.min(i + ranges[i], n);
                //更新起点的最远可达
                points[l] = Math.max(points[l], r);
            }
            int ans = 0;
            int pre = 0, max = 0;
            while (max < n) {
                int i = pre;
                int curMax = 0;
                while (i <= max) {
                    curMax = Math.max(points[i], curMax);
                    i++;
                }
                if (curMax <= max) {
                    return -1;
                }
                pre = max;
                max = curMax;
                ans++;
            }
            return ans;
        }
    }
}
