package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-02 Time: 09:22
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] returns=new int[nums.length];
        int left=1;
        returns[0]=1;
        for (int i = 1; i < nums.length; i++) {
            left*=nums[i-1];
            returns[i]=left;

        }
        int right=1;
        for (int l = nums.length-2; l >= 0; l--) {
            right*=nums[l+1];
            returns[l]*=right;

        }
        return returns;
    }
}
