package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-16 Time: 10:13
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        return count(coins, amount, coins.length - 1);

    }

    /**
     * 暴力递归回溯
     */
    int count(int[] coins, int amount, int index) {
        if (amount == 0) return 0;
        int rtn = Integer.MAX_VALUE;
        int count = 0;
        for (int i = index; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            } else if (coins[i] == amount) {
                return 1;
            } else {
                count = amount / coins[i];
                int remain = -1;
                int j = count;
                int minCount = Integer.MAX_VALUE;
                for (; j >= 0; j--) {
                    remain = count(coins, amount - j * coins[i], index - 1);
                    if (remain != -1) {
                        minCount = Math.min(remain + j, minCount);
                    }
                }
                if (minCount != Integer.MAX_VALUE) {
                    rtn = Math.min(minCount, rtn);
                }

            }
        }
        return rtn == Integer.MAX_VALUE ? -1 : rtn;
    }

    /**
     * 动态规划，利用推导公式进行计算。
     * @param coins
     * @param amount
     * @return
     */

    int dync(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] mins = new int[amount + 1];
        mins[0] = 0;
        for (int i = 1; i < mins.length; i++) {     //i表示当前要计算的金额是多少，
            if (i < coins[0]) { //如果金额小于最小面值，则直接设置为-1
                mins[i] = -1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = coins.length - 1; j >= 0; j--) { //用面值数组对当前金额做切割，求出当前金额的最小组合数量
                    if (i - coins[j] >= 0 && mins[i - coins[j]] >= 0) {

                        min = Math.min(mins[i - coins[j]] + 1, min);
                    }
                }
                mins[i] = min == Integer.MAX_VALUE ? -1 : min; //如果没有这样的组合，则给当前金额设置为-1
            }

        }
        return mins[amount];
    }


}
