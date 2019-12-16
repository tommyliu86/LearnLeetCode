package com.lwf.TOP100.normal;

import org.omg.PortableServer.ForwardRequest;

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



}
