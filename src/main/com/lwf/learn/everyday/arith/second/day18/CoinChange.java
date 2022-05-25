package com.lwf.learn.everyday.arith.second.day18;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-30 11:33
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount==0){
                return 0;
            }
            Arrays.sort(coins);
            int[] mark = new int[amount + 1];
            mark[0]=1;
            int[] count = new int[amount + 1];

            for (int i = coins[0]; i < mark.length; i++) {
                count[i]=i;
                for (int j = coins.length - 1; j >= 0; j--) {
                    int i1 = i - coins[j];
                    if (i1 >= 0 && mark[i1] == 1) {
                        mark[i] = 1;

                        count[i] = Math.min( count[i1] + 1,count[i]);
                    }
                }


            }
            return mark[amount]==1?count[amount]:-1;
        }
    }
}
