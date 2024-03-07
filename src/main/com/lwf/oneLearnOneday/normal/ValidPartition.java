package com.lwf.oneLearnOneday.normal;

/**
 * 2369. 检查数组是否存在有效划分
 * @author: liuwenfei
 * @date: 2024/3/7-19:35
 */
public class ValidPartition {
    /**
     * dp 动态规划，使用dp，每个i的位置作为最后一位，则i-1~i和i-2~i是否能够构成有效子数组，然后记录
     *
     */
    class Solution {
        public boolean validPartition(int[] nums) {
            boolean[] mark=new boolean[nums.length+1];
            mark[0]=true;
            for (int i = 2; i < mark.length; i++) {
                if (i-2>=1&&check(nums,i-3)){
                    mark[i]=mark[i-3];
                }
                if (!mark[i]&&nums[i-1]==nums[i-2]){
                    mark[i]=mark[i-2];
                }
            }
            return mark[nums.length];
        }

        private boolean check(int[] nums, int i) {
            if (nums[i]==nums[i+1]&&nums[i+1]==nums[i+2]){
                return true;
            }
            if (nums[i]+1==nums[i+1]&&nums[i+1]+1==nums[i+2]){
                return true;
            }
            return false;
        }
    }
}
