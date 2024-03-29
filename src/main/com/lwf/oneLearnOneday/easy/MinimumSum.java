package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * 2908. 元素和最小的山形三元组 I
 * @author: liuwenfei
 * @date: 2024/3/29-13:21
 */
public class MinimumSum {
    /**
     * 两次遍历，
     * 第一次从左向右，更新每个节点作为中间节点的最小值，如果没有则为-1
     * 第二次从右向左，更新每个可作为中间节点的节点的最小值，同时记录min_count更新
     */
    class Solution {
        public int minimumSum(int[] nums) {
            int[] minCount=new int[nums.length];
            Arrays.fill(minCount,-1);
            int left=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>left) {
                    minCount[i]=left+nums[i];
                }
                left=Math.min(left,nums[i]);
            }
            int rtn=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (minCount[i]!=-1&& nums[i]>right){
                    rtn=Math.min(rtn,minCount[i]+right);
                }
                right=Math.min(right,nums[i]);
            }
            return rtn==Integer.MAX_VALUE?-1:rtn;
        }
    }
}
