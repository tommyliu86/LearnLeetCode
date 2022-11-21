package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/11/18 9:36
 */
public class SumSubseqWidths {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            if ((1L<<i)!=Math.pow(2,i)) {
                System.out.println("false");
            }
        }
    }

    /***
     * 位运算仅能在32位数以内才能使用，超过位数之后会进行丢弃！！所以使用时需要注意的！
     */
   static class Solution {

        public int sumSubseqWidths(int[] nums) {

            int n = nums.length;
            int mod=1000000007;
            int[] pows=new int[n];
            pows[0]=1;
            for (int i = 1; i < pows.length; i++) {
                pows[i]=pows[i-1]*2%mod;
            }

            long ans = 0;
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                ans +=( pows[i]-pows[n-1-i] )*nums[i];
                ans%=mod;
            }
            return (int) ans;
        }
    }


    /**
     * 排序后的最大最小选择不会影响子序列中的最大最小值，因为子序列任意一个元素都可以选或不选，排序后仍然是选或不选。最大最小值不会有变化
     */
    class Solution1 {

        public int sumSubseqWidths(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int MOD=1000000007;
            long ans=0;

            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                ans += ((1<<i) * nums[i]) % MOD;
                ans %= MOD;
                ans -= ((1<<(n-1-i))* nums[i]) % MOD;
                ans %= MOD;

            }
            return (int) ans;
        }
    }
}
