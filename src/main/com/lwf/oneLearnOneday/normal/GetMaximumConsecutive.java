package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetMaximumConsecutive {
    /**
     * dp思路，需要考虑f(i)可以构造出连续数组0~x,再添加一个数y时，是否可以构造出比x大的连续数组，则可以知道
     * y从1到x+1，都满足让f(i+1)继续连续，，从最初开始推算，f(0)==0,需要的y==1,因此，需要的是排序后的coins，这里的关键是coins排序！！
     */
    class Solution {
        public int getMaximumConsecutive(int[] coins) {
            int ans=0;
            Arrays.sort(coins);
            for (int i = 0; i < coins.length; i++) {
                if (coins[i]>ans+1) {
                    return ans;
                }else{
                    ans+=coins[i];
                }
            }
            return ans;
        }
    }
}
