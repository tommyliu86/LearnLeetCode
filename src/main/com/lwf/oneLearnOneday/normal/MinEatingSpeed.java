package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 需要注意，并不是==h时就算作找到了，而是要找<=h的sum的最大值！
 * @author: liuwenfei14
 * @date: 2022-06-07 09:24
 */
public class MinEatingSpeed {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            Arrays.sort(piles);
            int max = piles[piles.length - 1];
            return half(piles, h, 1, max);

        }

        public int half(int[] piles, int h, int l, int r) {
            if (l >= r) {
                return l;
            }
            int m = (l + r) / 2;
            int sum = sum(piles, m);
            if (sum > h) {
                return half(piles, h, m + 1, r);
            } else {
                return half(piles, h, l, m);
            }
        }

        public int sum(int[] piles, int m) {
            int sum = 0;
            for (int i = 0; i < piles.length; i++) {
                sum += (piles[i] / m) + ((piles[i] % m) > 0 ? 1 : 0);
            }
            return sum;
        }
    }
}
