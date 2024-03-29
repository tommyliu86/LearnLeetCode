package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/7/20 8:42
 */
public class MaxSubArray {
    /**
     * 动态规划 简化dp,不使用数组，直接使用常数空间
     */
    class Solution {
        public int maxSubArray(int[] nums) {

            int max=Integer.MIN_VALUE,dp=0;
            for (int i = 0; i < nums.length; i++) {
                dp+=nums[i];
                max=Math.max(dp,max);
                if (dp<0){
                    dp=0;
                }
            }
            return max;
        }
    }
    /**
     * DP 动态规划  状态转移方程  f[i]= f[i-1]+n[i]  / n[i]  /f[i-1]
     *  1. 选当前  ，则分为两种情况，前缀和加上和不加上
     *  2.不选当前，则最大和是 f[i-1]
     */
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int[] dp=new int[nums.length+1];
            dp[0]=-100001;
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                dp[i+1]=Math.max(nums[i],dp[i]+nums[i]);
                max=Math.max(max,Math.max(dp[i] ,dp[i+1]));
            }
            return max;
        }
    }
    /**
     * 双指针，保留的是前缀和，然后非空的话，直接记录一次所有元素的比较即可
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int max=Integer.MIN_VALUE; // 初始化最大值为最小整数，确保能够比较数组中的任意值
            int i=0,j=0,sum=0; // 初始化指针i、j以及和sum
            while (j<nums.length){ // 循环遍历数组
                max=Math.max(max,nums[j]); // 计算当前子数组的最大值
                sum+=nums[j++]; // 累加子数组中的元素，并将指针j右移一位
                if (sum<=0){ // 如果当前子数组的和小于等于0
                    i=j; // 将指针i跟随指针j一起右移，开始新的子数组
                    sum=0; // 重置和sum为0
                }else{
                    max=Math.max(sum,max); // 更新最大值为当前子数组的和与上一个最大值的较大值
                }
            }
            return max; // 返回整个数组中的最大子数组和
        }
    }

}
