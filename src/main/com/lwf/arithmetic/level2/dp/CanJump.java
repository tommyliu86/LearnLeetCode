package com.lwf.arithmetic.level2.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 15:27
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            int max=nums[0];
            for (int i = 1;i<=max&& i < nums.length; i++) {
                max=Math.max(max,nums[i]+i);
            }
            return max>=nums.length-1;
        }
    }
}
