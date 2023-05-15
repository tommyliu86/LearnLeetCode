package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/5/12 8:54
 */
public class MaxValueAfterReverse {
    /**
     * 枚举所有的可能性：
     * 1.不做交换，
     * 2.交换从 0~k，
     * 3.交换从k~n
     * 4.交换 j~k，这时需要额外分析
     *  1.4个数字的 i，i+1，j，i+1，由于公式是固定的，因此我们需要考虑如何把绝对值表示法拆分，因此考虑对他们进行排列组合即可
     *  i，i+1 = 1，2   1，3  1，4  2，3， 2，4  3，4   一共6种可能。
     */
    class Solution {
        public int maxValueAfterReverse(int[] nums) {
            int l = nums.length;
            int val = 0;
            int v1 = 0, v2 = 0;
            //较大数的小
            int bmin = Integer.MAX_VALUE;
            //较小数的大
            int smax = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                val += Math.abs(nums[i] - nums[i - 1]);
                v1 = Math.max(v1, Math.abs(nums[i] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
                v2 = Math.max(v2, Math.abs(nums[i-1] - nums[l - 1]) - Math.abs(nums[i] - nums[i - 1]));
                bmin = Math.min(bmin, Math.max(nums[i], nums[i - 1]));
                smax = Math.max(smax, Math.min(nums[i], nums[i - 1]));
            }
            val = Math.max(Math.max(val, val + Math.max(v1, v2)), val + 2 * (smax - bmin));
            return val;

        }
    }
}
