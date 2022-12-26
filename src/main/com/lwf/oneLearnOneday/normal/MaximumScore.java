package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/12/22 17:53
 */
public class MaximumScore {
    /**
     * 模拟思路
     */
    class Solution {
        public int maximumScore(int a, int b, int c) {
            int[] ints = new int[3];
            ints[0] = a;
            ints[1] = b;
            ints[2] = c;
            int ans = 0;

            Arrays.sort(ints);
            while (ints[0] > 0 || ints[1] > 0) {

                if (ints[0] + ints[1] <= ints[2]) {
                    ans += ints[0] + ints[1];
                    break;
                } else {
                    int gap = ints[1] == ints[0] ? 1 : ints[1] - ints[0];
                    ans+=gap;
                    ints[2]-=gap;
                    ints[1]-=gap;
                }

                Arrays.sort(ints);
            }
            return ans;
        }
    }
}
