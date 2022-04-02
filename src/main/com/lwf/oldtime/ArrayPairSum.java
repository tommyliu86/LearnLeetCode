package com.lwf.oldtime;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-27-23:41
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i=i+2) {
            sum+=nums[i];
        }
        return sum;
    }
}
