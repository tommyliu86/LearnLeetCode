package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/7/4 8:32
 */
public class MatrixSum {
    /**
     * 排序+遍历模拟
     */
    class Solution {
        public int matrixSum(int[][] nums) {
            for (int i = 0; i < nums.length; i++) {
                Arrays.sort(nums[i]);
            }
            int ans=0;
            for (int i = nums[0].length - 1; i >= 0; i--) {
                int max=0;
                for (int i1 = 0; i1 < nums.length; i1++) {
                    max=Math.max(nums[i1][i],max);
                }
                ans+=max;
            }
            return ans;
        }
    }
}
