package com.lwf.learn.everyday.second.day14;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-26 10:17
 */
public class NumberOfArithmeticSlices {
    /**
     * dp 动态规划，对于等差数列的状态转移方程：数列长度每增加一，相当于增加了所有的以末尾元素为末尾的等差数列，
     * 也就是对于长度i的等差数列，dp表示以i为结尾的个数，也就是相对于原来增加的个数，dp(i)=i-2；,sum(i)=1+2+3+..+(i-2);
     */
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int sum=0;
            int left=0;
            int right=left+1;
            while (left<nums.length-2){
                int diff=nums[right]-nums[left];
                int sub=0;
                while (right<nums.length-1&& nums[ ++right]-nums[right-1]==diff){
                    sub+=right-left+1-2;
                }
                sum+=sub;
                left=right-1;
            }
            return sum;
        }
    }
}
