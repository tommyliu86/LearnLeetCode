package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 18:33
 */
public class Rob2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length<2) return nums[0];
            int[] chose=new int[nums.length];
            int[] nochose=new int[nums.length];
            chose[0]=nums[0];
            chose[1]=nums[0];
            nochose[0]=0;
            chose[1]=nums[1];
            for (int i = 2; i < nums.length; i++) {
                chose[i]=Math.max(chose[i-1],chose[i-2]+nums[i]);
                nochose[i]=Math.max(nochose[i-1],nochose[i-2]+nums[i]);
            }
            return Math.max(chose[nums.length-2],nochose[nums.length-1]);
        }
    }
}
