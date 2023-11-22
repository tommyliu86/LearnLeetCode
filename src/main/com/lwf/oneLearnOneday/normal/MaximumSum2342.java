package com.lwf.oneLearnOneday.normal;

/**
 * 2342. 数位和相等数对的最大和
 * @author liuwenfei
 * @date 2023/11/22 8:48
 */
public class MaximumSum2342 {
    /**
     * 遍历  + hash   使用数组来存储数位和的最大值，遍历数组，计算到当前的数位和之后，和max相加的和作为数和来进行max比较
     * 因为当前数位和相同的新增的一个值，如何计算相同数位元素中的最大和，就是使用当前值+max
     */
    class Solution {
        public int maximumSum(int[] nums) {
            int[] maxN=new int[100];
            int max=0;
            for (int i = 0; i < nums.length; i++) {
                int cur = getSum(nums[i]);
                if (maxN[cur]>0){
                    max=Math.max(nums[i]+maxN[cur],max);
                }
                maxN[cur]=Math.max(maxN[cur],nums[i]);

            }
            return max==0?-1:max;
        }

        private int getSum(int num) {
            int ans=0;
            while (num>0){
                int i = num % 10;
                ans+=i;
                num=num/10;
            }
            return ans;

        }
    }
}
