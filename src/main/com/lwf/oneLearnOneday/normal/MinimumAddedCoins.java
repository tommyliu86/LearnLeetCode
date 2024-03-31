package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * from home
 * author: liuwu
 * time: 2024/3/30 9:22
 */
public class MinimumAddedCoins {
    /**
     * coins排序后，从1开始到target进行遍历,
     * 1.对于小于i的coin，可以添加到sum中，因为1~i-1是我们已知的sum，因此添加一个coin=c进来，我们就可以知道获取 c+i-1的所有sum
     * 如果这个位置没有和，则需要添加这个面值，
     * 添加后，从这个位置向后的i-1个都肯定有和，因此i可以直接移动到i+i的位置
     */
    class Solution {
        public int minimumAddedCoins(int[] coins, int target) {

            Arrays.sort(coins);
            int count = 0;
            int c = 0;
            for (int i = 1; i <= target; ) {
                //小于i的coin，都可以和当前i-1组成新的数组。因此和会变成i-1+coin
                if (c < coins.length && coins[c] <= i) {
                    i = i + coins[c++];
                } else {
                    //coins中在i这个位置没有硬币，则需要直接添加coin=i
                    count++;
                    i = i + i;
                }
            }
            return count;
        }
    }
}
