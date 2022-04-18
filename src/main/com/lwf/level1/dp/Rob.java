package com.lwf.level1.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 16:57
 */
public class Rob {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length==1){
                return nums[0];
            }
            int[] price=new int[nums.length];
            price[0]=nums[0];
            price[1]=Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                price[i]=Math.max(price[i-1],price[i-2]+nums[i]);
            }
            return price[nums.length-1];
        }
    }
}
