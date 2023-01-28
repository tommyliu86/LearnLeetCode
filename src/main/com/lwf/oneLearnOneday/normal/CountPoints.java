package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/28 11:13
 */
public class CountPoints {
    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] ans=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                for (int j = 0; j < points.length; j++) {
                    if (point(points[j],query)){
                        ans[i]++;
                    }
                }
            }
            return ans;
        }
        private boolean point(int[] point,int[] query){
            return query[2] * query[2] >= (query[0] - point[0]) * (query[0] - point[0]) + (query[1] - point[1]) * (query[1] - point[1]);
        }
    }
}
