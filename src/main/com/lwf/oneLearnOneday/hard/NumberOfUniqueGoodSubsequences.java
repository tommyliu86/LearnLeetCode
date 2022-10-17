package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2022/10/14 19:02
 */
public class NumberOfUniqueGoodSubsequences {
    /**
     * 类似于940，使用动态规划找到状态转移方程，进行子序列不断累加
     */
    class Solution {
        public int numberOfUniqueGoodSubsequences(String binary) {
            int mod=1000000007;
            char[] chars = binary.toCharArray();
            int[] sums=new int[2];
            boolean hasZero=false;
            for (int i = chars.length - 1; i >= 0; i--) {
                int cur = chars[i]-'0';
                if (!hasZero&&cur==0) {
                    hasZero=true;
                }
                int curSum=sums[0]+sums[1]+1;
                sums[cur]=curSum%mod;
            }
            return sums[1]+(hasZero?1:0);
        }
    }
}
