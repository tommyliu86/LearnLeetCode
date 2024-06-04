package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * 2928. 给小朋友们分糖果 I
 *
 * @author: liuwenfei
 * @date: 2024/6/3-8:22
 */
public class DistributeCandies {
    /**
     * 要分完。。
     */
    class Solution {
        public int distributeCandies(int n, int limit) {
            int ans =0;
            for (int i = 0; i <= Math.min(n,limit); i++) {
                for (int j = 0; j <= Math.min(limit, n - i); j++) {
                    if (n-i-j<=limit) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int distributeCandies(int[] candyType) {
            Set<Integer> sets = new HashSet<>();
            for (int i = 0; sets.size() < candyType.length / 2 && i < candyType.length; i++) {
                sets.add(candyType[i]);

            }
            return sets.size();
        }
    }
}
