package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-21 19:24
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] nums = new int[amount + 1];

            for (int i = 1; i < nums.length; i++) {
                int count = amount + 1;

                for (int j = 0; j < coins.length; j++) {
                    int coin = coins[j];

                    if (i - coin >= 0 && nums[i - coin] >= 0) {
                        count = Math.min(count, nums[i - coin]+1);
                    }
                }
                if (count == amount + 1) {
                    nums[i] = -1;
                } else {
                    nums[i] = count;
                }

            }
            return nums[amount];
        }
    }
}
