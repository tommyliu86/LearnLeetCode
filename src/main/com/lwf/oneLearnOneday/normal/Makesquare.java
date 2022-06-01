package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-01 15:21
 */
public class Makesquare {
    /**
     * 暴力递归
     */
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            if (matchsticks.length < 4) {
                return false;
            }
            Arrays.sort(matchsticks);
            int sum = 0;
            for (int i = 0; i < matchsticks.length; i++) {
                sum += matchsticks[i];
            }
            if (sum % 4 != 0) {
                return false;
            }
            int[] sums = new int[4];
            for (int i = 0; i < sums.length; i++) {
                sums[i] = sum / 4;
            }

            return recursive(matchsticks, sums, matchsticks.length - 1);

        }

        public boolean recursive(int[] matchs, int[] sums, int index) {
            if (index < 0) {
                return true;
            }
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] >= matchs[index]) {
                    sums[i] -= matchs[index];
                    if (recursive(matchs, sums, index - 1)) {
                        return true;
                    }
                    sums[i] += matchs[index];
                }
            }
            return false;
        }
    }
}
