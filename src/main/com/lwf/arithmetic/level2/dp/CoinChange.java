package com.lwf.arithmetic.level2.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 16:16
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[] sum = new int[amount+1];
            for (int i = 1; i <= amount; i++) {
                int sub=amount+1;
                for (int j = coins.length - 1; j >= 0; j--) {
                    if (i - coins[j] >= 0 && sum[i - coins[j]] != -1) {
                        sub =Math.min(  sum[i - coins[j]] + 1,sub);
                    }
                }
                sum[i]=sub==amount+1?-1:sub;
            }
            return sum[amount];
        }
    }
}
