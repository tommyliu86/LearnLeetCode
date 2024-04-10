package com.lwf.oneLearnOneday.easy;

/**
 * 2529. 正整数和负整数的最大计数
 * @author: liuwenfei
 * @date: 2024/4/10-8:57
 */
public class MaximumCount {
    /**
     * 非递减，也就是元素是不变或变大的，允许重复，
     * 二分查找，找到第一个大于0的，是所有的正数，找到第一个大于-1的，是包含0的，这样就找到负数了
     */
    class Solution {
        public int maximumCount(int[] nums) {
            int pos=binary(nums,0);
            int og=binary(nums,-1);
            return Math.max(nums.length-pos,og);
        }
        public int binary(int[] nums,int t){
            int i=0,j=nums.length;
            while (i<=j){
                int m=i+(j-i)/2;
                if (nums[m]>t){
                    j=m;
                }else{
                    i=m+1;
                }
            }
            return j;
        }
    }
}
