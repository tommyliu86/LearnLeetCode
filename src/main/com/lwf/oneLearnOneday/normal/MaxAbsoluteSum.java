package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/8/8 8:52
 */
public class MaxAbsoluteSum {
    /**
     * 遍历
     * 使用常量保存 最大值，最小值的presum，每次计算curSum和 min，max的差值即可
     * 优化考虑：我们需要每次计算吗？我们获取到最大和最小前缀，两者的差距肯定是最大的。因此直接记录，最后计算即可
     */
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int preSum=0;
            int minS=0,maxS=0,ans=0;
            for (int i = 0; i < nums.length; i++) {
                preSum+=nums[i];
                minS=Math.min(minS,preSum);
                maxS=Math.max(maxS,preSum);
            }

            return Math.abs(maxS-minS);
        }
    }
    class Solution1 {
        public int maxAbsoluteSum(int[] nums) {
            int preSum=0;
            int minS=0,maxS=0,ans=0;
            for (int i = 0; i < nums.length; i++) {
                preSum+=nums[i];

                ans=Math.max(ans,Math.max( Math.abs(preSum-minS), Math.abs(preSum-maxS)));

                minS=Math.min(minS,preSum);
                maxS=Math.max(maxS,preSum);
            }
            return ans;
        }
    }
}
