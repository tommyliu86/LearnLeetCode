package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/8/31 8:41
 */
public class MinTrioDegree {
    /**
     * 类记忆化搜索
     * 排序+遍历
     */
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            int[] points=new int[n+1];
            int[][] eds=new int[n+1][n+1];
            for (int[] edge : edges) {
                points[edge[0]]++;
                points[edge[1]]++;
                eds[edge[0]][edge[1]]++;
                eds[edge[1]][edge[0]]++;
            }


            int ans=Integer.MAX_VALUE;
            for (int i = 1; i < n+1; i++) {

                if (points[i]<2) {
                    continue;
                }
                for (int j = i+1; j <= n; j++) {
                    if (eds[i][j]>0){
                        for (int k = j+1; k <= n; k++) {
                            if (eds[i][k]>0&&eds[j][k]>0){
                                ans=Math.min( points[i]+points[j]+points[k]-6,ans);
                            }
                        }
                    }
                }
            }
            return ans==Integer.MAX_VALUE?-1:ans;


        }
    }
}
