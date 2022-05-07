package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 10:19
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            int start = 0;
            int max = nums[0];
            int step = 1;
            while (start < max && max < nums.length - 1) {
                int nMax = 0;
                for (int i = start; i <= max; i++) {
                    nMax = Math.max(i + nums[i], nMax);
                }
                start = max;
                max = nMax;
                step++;
            }
            return step;
        }
    }
}
