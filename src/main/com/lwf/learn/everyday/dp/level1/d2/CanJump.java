package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 14:22
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            int max=nums[0];
            int i=0;
            while (max<nums.length-1&& i<max){
                max=Math.max(max,i+nums[i]);
                i++;
            }
            return max>=nums.length-1;
        }
    }
}
