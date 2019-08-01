package com.lwf;

import java.util.HashMap;

/**
 * author Administrator
 * time 2019-08-01
 */
public class NumArray {
    int[] mynums;

    public NumArray(int[] nums) {
        mynums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == j) return mynums[i];
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += mynums[k];
        }
        return sum;
    }
}

/**
 * 缓存和值，避免每次都求和
 */
 class NumArray1 {
   int[] map;

    public NumArray1(int[] nums) {
        map=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            map[i+1]=map[i]+ nums[i];
        }
    }

    public int sumRange(int i, int j) {
      return map[j+1]-map[i];
    }
}

