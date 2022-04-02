package com.lwf.TOP100.easy;

/**
 * author Administrator
 * time 2019-09-13-0:50
 * {@link 198.md}
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums==null) return 0;
        if (nums.length<2) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int first=0;
        int second=0;
        int third=0;
        int i=0;
        while (i<nums.length){
            third=Math.max(second,first+nums[i]);
            first=second;
            second=third;
            i++;
        }
        return  second;
    }
}
