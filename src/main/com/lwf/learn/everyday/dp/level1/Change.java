package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * dp思路，在计算组合时，如何进行？这里不再是从金额之和来考虑，而是通过从组合的coin来考虑，首先考虑只用一种coin。则
 * coins[0] *i的所有金额的组合都是1.
 * 然后加第二种coin进来，每个coin[1]*i  的金额的组合也都是1，如果在第二种coin[1]的金额之和已经用第一个硬币组合过了，
 * 那这个自然就会变成2种组合，且组合的可能性不会重复。
 *
 * @author: liuwenfei14
 * @date: 2022-05-22 09:46
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            int[] count=new int[amount+1];
            count[0]=1;
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                for (int j = coin; j < count.length; j++) {
                    count[j]+=count[j-coin];
                }
            }
            return count[amount];
        }
    }
}
