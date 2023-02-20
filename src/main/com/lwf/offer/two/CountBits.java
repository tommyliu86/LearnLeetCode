package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/2/17 13:53
 */
public class CountBits {
    //可以通过考虑每个i+1比i多了几个位来考虑，假设i/2==1，则f(i+1)=f(i)+1, i/2==0,则 f(i)=f(i/2)
    class Solution {
        public int[] countBits(int n) {
            int[] ans=new int[n+1];
            for (int i = 1; i < ans.length; i++) {
                ans[i]=i%2==0?ans[i>>>1]:(ans[i-1]+1);
            }
            return ans;
        }
    }

    //直接计算每个数字的位
    class Solution1 {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i < ans.length; i++) {
                ans[i] = countBit(i);
            }
            return ans;
        }

        public int countBit(int i) {
            int ans = 0;
            while (i != 0) {
                i = i & (i - 1);
                ans++;
            }
            return ans;
        }
    }
}
