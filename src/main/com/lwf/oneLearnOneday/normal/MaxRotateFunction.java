package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 08:31
 */
public class MaxRotateFunction {
    /**
     * dp动态规划， 找到F的转移公式
     */
    class dp {
        public int maxRotateFunction(int[] nums) {
            int f0=0;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                f0+=i*nums[i];
                count+=nums[i];
            }

            int max=f0;
            int cursor=1;
            while (cursor<nums.length){
                f0=f0-nums.length*nums[nums.length-cursor]+count;

                max=Math.max(f0,max);
                cursor++;
            }

            return max;
        }
    }
    /**
     * 暴力循环，会超时。。
     */
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int cursor=0;
            int max=Integer.MIN_VALUE;
            while (cursor<nums.length){
                int count=0;
                for (int next = 1; (next+cursor)%nums.length != cursor; next++) {
                    count+=next*nums[(next+cursor)%nums.length];
                }
                max=Math.max(count,max);
                cursor++;
            }
            return max;
        }
    }
}
