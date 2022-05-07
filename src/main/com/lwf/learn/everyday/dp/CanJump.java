package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 09:52
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            int max = nums[0];
            for (int i = 0; i <= max && i < nums.length; i++) {

                max = Math.max(i + nums[i], max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
        public boolean canJump1(int[] nums) {
            int max = nums[0];
            int i=0;
            while (i<=max&&i<nums.length){
                max=Math.max(i+nums[i],max);
                i++;
            }
            return i>=nums.length-1;
        }
    }
}
