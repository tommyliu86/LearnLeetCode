package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 16:03
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (amount==0) return 1;
            int[] count=new int[amount+1];
            Arrays.sort(coins);
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                for (int j = coin; j < count.length; j++) {
                    //如果j-coin不是0种可能，则这种组合肯定没出现过，可以+上
                    count[j]+=(j-coin==0?1: count[j-coin]);
                }
            }
            return count[amount];
        }
    }
}
