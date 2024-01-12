package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * @author liuwenfei
 * @date 2024/1/8 8:30
 */
public class NumberOfBoomerangs {
    /**
     * 暴力求解，直接使用双循环进行遍历,欧式距离。。
     */
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int ans =0;
            for (int i = 0; i < points.length; i++) {
                int[] cur = points[i];
                Map<Integer,Integer> counts=new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (j==i)continue;
                    int calc = calc(cur, points[j]);
                    counts.put(calc,counts.getOrDefault(calc,0)+1);
                }
                for (Integer v : counts.values()) {
                    ans+=v*(v-1);
                }
            }
            return ans;
        }
        public int calc(int[] a,int[] b){
            return (a[0] -b[0])*(a[0] -b[0])+(a[1]-b[1])*(a[1]-b[1]);
        }
    }
}
