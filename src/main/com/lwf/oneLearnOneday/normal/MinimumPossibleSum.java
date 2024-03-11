package com.lwf.oneLearnOneday.normal;

/**
 * 2834. 找出美丽数组的最小和
 *
 * @author: liuwenfei
 * @date: 2024/3/8-9:55
 */
public class MinimumPossibleSum {
    /**
     * 我们使用一个额外数组来保存不能使用的数字，超时
     * 其实我们可以直接计算，
     */
    class Solution {
        public int minimumPossibleSum(int n, int target) {
            long sum = 0;
            int max = (target) / 2;
            if (max >= n) {
                sum = (long) (1 + n) * n / 2;
            } else {
                sum = (int) (((long) (1 + max) * max / 2 +
                        ((long) target + target + n - max - 1) * (n - max) / 2) % 1000_000_007);
            }

            return (int) sum % 1000_000_007;
        }
    }
}
