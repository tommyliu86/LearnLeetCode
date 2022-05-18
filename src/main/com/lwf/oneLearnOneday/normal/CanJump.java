package com.lwf.oneLearnOneday.normal;



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
    public boolean canJump1(int[] nums) {
        if(nums.length<2) return true;
        int maxIndex=0;
        for (int i = 0; i <nums.length; i++) {
            if (i<=maxIndex){
                maxIndex=Math.max(maxIndex,i+nums[i]);
            }else{
                return false;
            }
        }
        return true;

    }
}
