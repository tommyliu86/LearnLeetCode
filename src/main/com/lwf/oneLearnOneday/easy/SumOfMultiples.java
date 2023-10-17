package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/17 8:42
 */
public class SumOfMultiples {
    /**
     * 直接遍历
     */
    class Solution {
        public int sumOfMultiples(int n) {
            int ans=0;
            for (int i = 1; i <= n; i++) {
                if (i%3==0||i%5==0||i%7==0)
                    ans+=i;
            }
            return ans;
        }
    }
}
