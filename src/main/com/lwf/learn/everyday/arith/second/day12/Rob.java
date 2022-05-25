package com.lwf.learn.everyday.arith.second.day12;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 08:57
 */
public class Rob {
    class Solution {

        /**
         * DP 动态规划，记录每个房间可以获取的最大，向后递推
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            if (nums.length<2) return nums[0];
            int[] maxes=new int[nums.length];
            maxes[0]=nums[0];
            maxes[1]=Math.max(maxes[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
             maxes[i]=Math.max(maxes[i-2]+nums[i],maxes[i-1]);
            }
            return maxes[nums.length-1];
        }
        /**
         * DP 动态规划，辅助数组记录当前最大是否包含第一个房间，错误
         * @param nums
         * @return
         */
        public int rob2(int[] nums) {
            if (nums.length<2) return nums[0];
            boolean[] index=new boolean[nums.length];
            index[0]=true;

            int[] maxes=new int[nums.length];
            maxes[0]=nums[0];
            maxes[1]=Math.max(maxes[0],nums[1]);
            if (nums[1]<nums[0]){
                index[1]=true;
            }
            for (int i = 2; i < nums.length; i++) {
                if (maxes[i-2]+nums[i]>maxes[i-1]){
                    maxes[i]=maxes[i-2]+nums[i];
                    index[i]=index[i-2];
                }else{
                    maxes[i]=maxes[i-1];
                    index[i]=index[i-1];
                }
            }
            if (index[index.length-1]) {
                return Math.max( maxes[index.length-2],nums[nums.length-1]);
            }else{
                return maxes[nums.length-1];
            }
        }
        /**
         * DP 动态规划，两路可能的推算
         * @param nums
         * @return
         */
        public int rob3(int[] nums) {
            if (nums.length<2) return nums[0];

            int[] chose=new int[nums.length];
            int[] nochose=new int[nums.length];
            chose[0]=nums[0];
            chose[1]=Math.max(nums[1],nums[0]);
            nochose[1]=nums[1];
            for (int i = 2; i < nums.length; i++) {
                chose[i]=Math.max(chose[i-1],chose[i-2]+nums[i]);
                nochose[i]=Math.max(nochose[i-1], nochose[i-2]+nums[i]);
            }
            return Math.max(nochose[nums.length-1],chose[nums.length-2]);
        }
    }
}
