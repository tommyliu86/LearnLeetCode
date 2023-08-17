package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/8/16 8:32
 */
public class CircularGameLosers {
    /**
     * 1+k+2k+3k+4k= 1+ i(i+1)/2 *k %n
     */
    class Solution {

        public int[] circularGameLosers(int n, int k) {
            int[] ns = new int[n];
            int i = 0;
            for (; i < n; i++) {
                int cur = (i * (i + 1) / 2) * k % n;
                if (ns[cur] == 1) {
                    break;
                }
                ns[cur] = 1;
            }
            int[] ans = new int[n - i];
            int c = 0;
            for (int j = 0; j < ns.length; j++) {
                if (ns[j] == 0) {
                    ans[c++] = j + 1;
                }
            }
            return ans;
        }
    }
}
