package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-09-23:38
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;

        int post=0;
        int sum=0;
        while (post<nums.length){
            sum+=nums[post];
            post++;
            max= Math.max(sum,max);
            if (sum<=0){
                sum=0;
            }

        }
        return max;
    }
}
