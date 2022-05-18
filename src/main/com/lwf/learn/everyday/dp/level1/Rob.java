package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 17:52
 */
public class Rob {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length<2){
                return nums[0];
            }
           int pre=nums[0];
           int cur=Math.max( nums[1],nums[0]);
            for (int i = 2; i < nums.length; i++) {
                int temp=cur;
                cur=Math.max(cur,pre+nums[i]);
                pre=temp;
            }
            return cur;
        }
    }
}
