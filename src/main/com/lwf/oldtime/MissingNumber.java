package com.lwf.oldtime;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-07-31
 * {@link 268.md}
 */
public class MissingNumber {
    /**
     * 排序后考虑头尾问题，所以检查nums【0】==0以及for完成后的nums[length-1]+1
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        if (nums[0]!=0) {
            return 0;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1]!=nums[i]+1) {
                return nums[i]+1;
            }
        }
        return nums[nums.length-1]+1;
    }

    /**
     * 使用Arrays.stream进行数组求和的话非常费时，直接使用foreach的相加节省时间
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
       int sum= 0;
        for (int num : nums) {
            sum+=num;
        }
       int n=nums.length;
       return n*(n+1)/2-sum;
    }
    public int missingNumber3(int[] nums) {
        int sum= 0;
        for (int i = 0; i < nums.length; i++) {
            sum^=i^nums[i];
        }
        return sum^nums.length;
    }

}
