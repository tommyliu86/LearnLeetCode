package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/2/10 14:54
 */
public class PrintNumbers {
    class Solution {
        public int[] printNumbers(int n) {
            int[] ans=new int[(int) Math.pow(10,n)-1];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=i+1;
            }
            return ans;
        }
    }
}
