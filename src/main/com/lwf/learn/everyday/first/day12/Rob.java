package com.lwf.learn.everyday.first.day12;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 09:05
 */
public class Rob {
    /**
     * 递推迭代，动态规划
     */
    class Solution {
        public int rob(int[] nums) {
            if (nums.length<2){
                return nums[0];
            }
            int[] max=new int[nums.length];
            max[0]=nums[0];
            max[1]=Math.max(nums[1], nums[0]);
            int index=2;
            while (index<nums.length){
                max[index]=Math.max( max[index-2]+nums[index],max[index-1]);
                index++;
            }
            return max[nums.length-1];
        }
    }
}
