package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 09:54
 */
public class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums=new int[nums.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i]=nums[i]+(i>0? sums[i-1]:0);
        }
    }

    public int sumRange(int left, int right) {
        return sums[right]-(left>0?sums[left-1]:0);
    }
}
