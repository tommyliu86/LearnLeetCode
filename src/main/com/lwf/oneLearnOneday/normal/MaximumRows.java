package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2397. 被列覆盖的最多行数
 * @author liuwenfei
 * @date 2024/1/4 8:54
 */
public class MaximumRows {
    /**
     * 每行都可以构成一个数字，然后进行位运算可以快速知道是否已经超过限制
     * 如何找到所有的组合情况？使用回溯，递归遍历所有组合，每一行都有选或不选
     */
    class Solution {
        public int maximumRows(int[][] matrix, int numSelect) {
            int[] ma=new int[matrix.length];
            for (int i = 0; i < ma.length; i++) {
                int[] ints = matrix[i];
                for (int j = 0; j < ints.length; j++) {
                    ma[i]|=ints[j]<<j;
                }
            }
            recurse(ma,0,0,0,numSelect);
            return ans;
        }
        int ans=0;
        public void recurse(int[] ma,int i, int count,int bi,int nums){
            if (i== ma.length|| Integer.bitCount(bi)>nums){
                return;
            }
            int cur = ma[i];
            if (Integer.bitCount( bi|cur)<=nums){
                ans=Math.max(ans,count+1);
                recurse(ma,i+1,count+1,bi|cur,nums);
            }
            recurse(ma,i+1,count,bi,nums);
        }
    }
}
