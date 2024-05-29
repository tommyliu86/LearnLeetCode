package com.lwf.oneLearnOneday.easy;

/**
 * 2903. 找出满足差值条件的下标 I
 *
 * @author: liuwenfei
 * @date: 2024/5/29-9:13
 */
public class FindIndices {
    /**
     * 两层循环
     */
    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length-1; j >= i+indexDifference; j--) {
                    if (Math.abs(nums[i]-nums[j])>=valueDifference){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{-1,-1};

        }
    }
}
