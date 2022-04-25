package com.lwf.learn.everyday.second.day13;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-25 10:07
 */
public class Jump {
    /**
     * 贪心算法，记录每次跳跃中的可以走到的最远，作为下一个step的选择即可。
     */
    class Solution {
        public int jump(int[] nums) {
            int max = 0;
            int step = 0;
            int left = 0;
            while (max < nums.length - 1) {
                int curM = max;
                for (int i = left; i <= curM; i++) {
                    if (i + nums[i] > max) {
                        max = i + nums[i];
                        left = i;
                    }
                }
                step++;
            }
            return step;
        }
    }
}
