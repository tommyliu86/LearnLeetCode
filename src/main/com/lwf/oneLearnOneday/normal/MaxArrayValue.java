package com.lwf.oneLearnOneday.normal;

/**
 * 2789. 合并后数组中的最大元素
 *
 * @author: liuwenfei
 * @date: 2024/3/14-18:20
 */
public class MaxArrayValue {
    /**
     * 单调栈，从后向前进行合并，每个元素只用访问一次，每次保留当前合并的最大值max，如果max>=nums[i],则合并，否则max=nums[i]
     */
    class Solution {
        public long maxArrayValue(int[] nums) {
            long max=0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i]<=max) {
                    max+=nums[i];
                }else{
                    max=nums[i];
                }
            }
            return max;
        }
    }
}
