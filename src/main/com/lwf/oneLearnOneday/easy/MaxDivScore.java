package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author: liuwenfei
 * @date: 2024/5/21-8:43
 */
public class MaxDivScore {
    class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            Arrays.sort(divisors);
            Arrays.sort(nums);
            int ans = 0, acount = 0;
            for (int i = divisors.length - 1; i >= 0; i--) {
                int d = divisors[i];

                int count = 0;
                for (int j = nums.length - 1; j >= 0; j--) {

                    int num = nums[j];
                    if (num >= d) {
                        if (num % d == 0)
                            count++;
                    } else {
                        break;
                    }
                }


                if (acount <= count) {
                    ans = d;
                    acount = count;
                }
            }

            return ans;
        }
    }
}
