package com.lwf.TOP100;

/**
 * author Administrator
 * time 2019-09-16-22:31
 * {@link 283.md}
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[pre++]=nums[i];
               if (pre!=i+1){
                   nums[i]=0;
               }
            }
        }
    }
}
