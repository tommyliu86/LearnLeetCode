package com.lwf.TOP100;

/**
 * author Administrator
 * time 2019-09-09-23:38
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int pre=0;
        int post=0;
        int sum=0;
        while (post<nums.length){
            sum+=nums[post];
            if (sum>0){
                post++;
                max= Math.max(sum,max);
            }else{
                pre=++post;
                max= Math.max(sum,max);
                sum=0;
            }

        }
        return max;
    }
}
