package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-12 10:43
 */
public class IntegerBreak {
    class Solution {
        /**
         * dp[i]表示当前i能拆分为的最大乘积，则可以知道动态方程是 dp[i]= i之前所有分解出来的数的乘积的max
         * @param n
         * @return
         */
        public int integerBreak(int n) {
            int[] multis=new int[n+1];
            for (int i = 2; i < multis.length; i++) {
                for (int j = 1; j < i; j++) {

                    multis[i]=Math.max(multis[i],Math.max((i-j)*j,multis[i-j]*j));
                }
            }
            return multis[n];
        }
    }
}
