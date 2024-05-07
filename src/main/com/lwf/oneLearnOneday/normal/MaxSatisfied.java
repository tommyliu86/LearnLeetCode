package com.lwf.oneLearnOneday.normal;

/**
 * @author: liuwenfei
 * @date: 2024/4/23-9:09
 */
public class MaxSatisfied {
    /**
     * 滑动窗口，顾客总数就是最大可以有的满意值，滑动窗口内记录避免生气最大即可
     */
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int cur = 0, max = 0, total = 0;
            int l = 0, r = 0;
            while (r < customers.length) {
                while (r - l + 1 > minutes) {
                    cur -= grumpy[l] == 1 ? customers[l] : 0;
                    l++;
                }
                cur += grumpy[r] == 1 ? customers[r] : 0;
                total += (grumpy[r] == 1 ? 0 : 1) * customers[r];
                max = Math.max(max, cur);
                r++;
            }
            return total+max;
        }
    }
}
