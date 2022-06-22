package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 15:39
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] count=new int[amount+1];
            Arrays.sort(coins);
            for (int i = 1; i < count.length; i++) {
                int a=i;
                count[i]=-1;
                for (int j = 0; j < coins.length; j++) {
                    if (a<coins[j]){
                        break;
                    }
                    if (a==coins[j]){
                       count[i]=1;
                        break;
                    }
                    if (a>coins[j]&&count[a-coins[j]]>0){
                       count[i]=count[i]==-1?(count[a-coins[j]]+1): Math.min(count[a-coins[j]]+1,count[i]);
                    }
                }

            }
            return count[amount];
        }
    }
}
