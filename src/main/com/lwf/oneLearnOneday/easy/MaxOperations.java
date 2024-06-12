package com.lwf.oneLearnOneday.easy;

/**
 * 3038. 相同分数的最大操作数目 I
 *
 * @author: liuwenfei
 * @date: 2024/6/7-9:32
 */
public class MaxOperations {
    class Solution {
        public int maxOperations(int[] nums) {
            int i=2,sum=nums[0]+nums[1],count=1;
            while (i+1<nums.length&&nums[i]+nums[i+1]==sum){
                i+=2;
                count++;
            }
            return count;
        }
    }
}
