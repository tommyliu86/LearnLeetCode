package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/3/30 9:37
 */
public class CountBits {
    class Solution {
        public int[] countBits(int n) {
            int[] ans=new int[n+1];
            //dp思路，奇数位置，比前一个数多了一个1，因此dp[i]=dp[i-1]+1
            //偶数位置，考虑和前面的哪个有关，此时可以知道，偶数的1的个数，应该和 i/2 相同，因为偶数的末尾为0，/2表示右移一位，因此可以直接dp
            for (int i = 1; i < ans.length; i++) {
                if (i%2==0) {
                    ans[i]=ans[i/2];
                }else{
                    ans[i]=ans[i-1]+1;
                }
            }
            return ans;
        }
    }
}
