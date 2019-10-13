package com.lwf.TOP100.normal;



/**
 * author Administrator
 * time 2019-10-13-22:20
 * {@link md/normal/55.md}
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        int min=1;
        for (int i = nums.length - 2; i >0; i--) {
            if (nums[i]<min){
                min++;
            }else{
                min=1;
            }
        }
        return nums[0]>=min;

    }
}
